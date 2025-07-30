class HomePage {
    elements = {
        productTitle: () => cy.get('.title'),
        productLink: () => cy.get('.inventory_item').first().find('a')
    }

    clickFirstProduct() {
        this.elements.productLink().first().click()
    }
}

export default HomePage;
