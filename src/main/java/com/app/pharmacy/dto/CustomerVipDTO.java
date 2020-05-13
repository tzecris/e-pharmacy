
package com.app.pharmacy.dto;

import java.awt.Image;


public class CustomerVipDTO extends CustomerDTO{
    
    private Image permissionImg;
    
    private Image idCopy;

    public CustomerVipDTO(Image permissionImg, Image idCopy) {
        this.permissionImg = permissionImg;
        this.idCopy = idCopy;
    }
    
    public CustomerVipDTO() {
    }

    public Image getPermissionImg() {
        return permissionImg;
    }

    public void setPermissionImg(Image permissionImg) {
        this.permissionImg = permissionImg;
    }

    public Image getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(Image idCopy) {
        this.idCopy = idCopy;
    }
    
    
}
