import LoginPage from '../pages/LoginPage'
import HomePage from '../pages/HomePage'
import ProductPage from '../pages/ProductPage'

const loginPage = new LoginPage()
const homePage = new HomePage()
const productPage = new ProductPage()

describe('Product Page Tests - SauceDemo', () => {

    beforeEach(() => {
        cy.visit('https://www.saucedemo.com/')
        loginPage.login('standard_user', 'secret_sauce')
    })

    it('Navigate to First Product', () => {
        homePage.clickFirstProduct()
        productPage.verifyProductPage()
    })
})
