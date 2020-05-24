package com.app.pharmacy.service;

import com.app.pharmacy.dto.ProductDTO;
import com.app.pharmacy.dto.ProductSearchFilters;
import com.app.pharmacy.dto.ReviewDTO;
import com.app.pharmacy.dto.SearchResults;
import com.app.pharmacy.mapper.ProductMapper;
import com.app.pharmacy.mapper.ReviewMapper;
import com.app.pharmacy.model.Product;
import com.app.pharmacy.model.ProductCategory;
import com.app.pharmacy.model.Review;
import com.app.pharmacy.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    EntityManager entityManager;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public List<ProductDTO> findAll() {
        return productMapper.entityToDTOList(productRepo.findAll());
    }

    @Override
    @Transactional
    public void save(ProductDTO dto) {
        productRepo.save(productMapper.dtoToEntity(dto));
    }

    @Override
    @Transactional
    public void addReview(ReviewDTO dto, Integer id) {
        Product product = productRepo.findById(id).get();
        Review review = reviewMapper.dtoToEntity(dto);
        review.setProduct(product);
        product.getRatingsPerCustomerList().add(review);
        productRepo.save(product);
    }

    @Override
    public ProductDTO findById(Integer id) {
        Optional<Product> result = productRepo.findById(id);
        return result.isPresent() ? productMapper.entityToDTO(result.get()) : null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        productRepo.deleteById(id);
    }

    @Override
    public SearchResults findAllPagination(int page, int size, String sort) {

        Pageable pageable
                = PageRequest.of(page, size, Sort.by(sort));
        Page pageObject = productRepo.findAll(pageable);
        SearchResults results
                = new SearchResults(productMapper.entityToDTOList(pageObject.getContent()), pageObject.getTotalElements());
        return results;

    }

    @Override
    public SearchResults findByFilter(int page, int size, String sort, String order, ProductSearchFilters psf) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = cb.createQuery(Product.class);
        Root<Product> itemRoot = criteriaQuery.from(Product.class);
        ListJoin<Product, ProductCategory> joinCategory = itemRoot.joinList("productCategoryList", JoinType.LEFT);

        List<Predicate> preList = new ArrayList<>();

        if (psf.getProductName() != null && !psf.getProductName().equals("")) {
            Predicate predicateForName = cb.like(cb.lower(itemRoot.get("name")), ("%" + psf.getProductName() + "%").toLowerCase());
            preList.add(predicateForName);
        }

        if (psf.getCategoryList() != null && !psf.getCategoryList().isEmpty()) {
            Expression<String> exp = joinCategory.get("categoryId");
            Predicate predicateForCategoryList = exp.in(psf.getCategoryList());
            preList.add(predicateForCategoryList);
        }

        if (psf.isStock()) {
            Predicate predicateForStock = cb.greaterThan(itemRoot.get("stock"), 0);
            preList.add(predicateForStock);
        }

        if (psf.isDiscount()) {
            Predicate predicateForDiscount = cb.greaterThan(itemRoot.get("discount"), 0);
            preList.add(predicateForDiscount);
        }

        if (psf.isPrescripted()) {
            Predicate predicateForPrescripted = cb.isTrue(itemRoot.get("prescripted"));
            preList.add(predicateForPrescripted);
        }

        Predicate predicateRangePrice = cb.between(itemRoot.get("price"), psf.getMinPrice(), psf.getMaxPrice());
        preList.add(predicateRangePrice);

        Predicate finalPredicate = cb.and(preList.toArray(new Predicate[preList.size()]));

        criteriaQuery.where(finalPredicate);

        if (order.equals("DESC")) {
            criteriaQuery.orderBy(cb.desc(itemRoot.get(sort)));
        } else {
            criteriaQuery.orderBy(cb.asc(itemRoot.get(sort)));
        }


        List<Product> items = entityManager.createQuery(criteriaQuery).setFirstResult(page).setMaxResults(size).getResultList();
        int itemsCount = entityManager.createQuery(criteriaQuery).getResultList().size();
        SearchResults results
                = new SearchResults(productMapper.entityToDTOList(items), itemsCount);

        return results;

    }

//    private Long count(List<Predicate> predicates) {
//        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
//        cq.select(qb.count(cq.from(Product.class)));
//        Predicate finalPredicate = qb.and(predicates.toArray(new Predicate[predicates.size()]));
//        cq.where(finalPredicate);
//        return entityManager.createQuery(cq).getSingleResult();
//    }

}
