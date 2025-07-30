class ProductPage {
    elements = {
        // Selector for product title on product detail page
        productTitle: () => cy.get('.inventory_details_name'),

        // Selector for the first product link on the product list page
        productLink: () => cy.get('.inventory_item a').first()
    }

    // Clicks the first product in the list
    clickFirstProduct() {
        this.elements.productLink().click();
    }

    // Verifies product detail page is visible
    verifyProductPage() {
        this.elements.productTitle().should('be.visible');
    }
}

export default ProductPage;
