
package com.app.pharmacy.dto;


public class CustomerVipDTO extends CustomerDTO{

    private byte[] permissionImg;

    private byte[] idCopy;

    
    public CustomerVipDTO(byte[] permissionImg, byte[] idCopy) {
        this.permissionImg = permissionImg;
        this.idCopy = idCopy;
    }

    public CustomerVipDTO() {
    }

    public byte[] getPermissionImg() {
        return permissionImg;
    }

    public void setPermissionImg(byte[] permissionImg) {
        this.permissionImg = permissionImg;
    }

    public byte[] getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(byte[] idCopy) {
        this.idCopy = idCopy;
    }

    
}
