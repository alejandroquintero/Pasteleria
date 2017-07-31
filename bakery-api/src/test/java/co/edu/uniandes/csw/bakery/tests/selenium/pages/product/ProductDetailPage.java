/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.bakery.tests.selenium.pages.product;

import co.edu.uniandes.csw.bakery.dtos.minimum.ProductDTO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage {

    @FindBy(id = "delete-product")
    private WebElement deleteBtn;

    @FindBy(id = "edit-product")
    private WebElement editBtn;

    @FindBy(id = "list-product")
    private WebElement listBtn;

    
    @FindBy(id = "description")
    private WebElement description;
  
    @FindBy(id = "portions")
    private WebElement portions;
 
    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "image")
    private WebElement image;

    public void list() {
        listBtn.click();
    }

    public void edit() {
        editBtn.click();
    }

    public void delete() {
        deleteBtn.click();
    }

    public ProductDTO getData() {
        ProductDTO product = new ProductDTO();        
        product.setDescription(this.description.getText());        
        
        product.setPortions(Integer.parseInt(this.portions.getText()));
      
        product.setName(this.name.getText());        
        product.setImage(this.image.getText());        
        return product;
    }
}