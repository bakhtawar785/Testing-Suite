import HomePage from '../pages/HomePage'

const homePage = new HomePage()

describe('Login Tests - SauceDemo', () => {

    beforeEach(() => {
        cy.visit('https://www.saucedemo.com/')
    })

    it('Valid Login', () => {
        cy.login('standard_user', 'secret_sauce')
        homePage.elements.productTitle().should('contain', 'Products')
    })

    it('Invalid Login', () => {
        cy.login('wrong_user', 'wrong_pass')
        cy.get('[data-test="error"]').should('be.visible')
            .and('contain', 'Username and password do not match any user') 
    })
})
