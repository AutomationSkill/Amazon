@Functional
Feature: User adds book to basket
  As a user
  I want to search book
  so that i can buy

  Scenario Outline: Open amazon page successfully
    Given user enters amazon
    When user selects book tab
    When user enters bookname "<bookName>"
    Then user is in books module
    Then verify the first item has the title "<title>"
    Then verify the book type is "<bookType>"
    Then verify the book price "<price>"
    Then navigate to "<title>"
    Then verify the book type in book details page as "<bookType>"
    When user add the book to basket
    Then verify the notification is shown as "Added to Basket"
    Then verify basket subtotal items are "Basket subtotal"
    When user selects edit basket
    Then verify the user is in shopping basket page "Shopping Basket"
    Then verify the book "<title>" is shown in the list
    Then verify the book type in basket is "<bookType>"
    Then verify the price in basket page is "<price>"
    Then verify the quantity in basket page is "<quantity>"
    Then verify the subtotal price in basket page as "Subtotal (1 item): £4.00"



    Examples:
      | bookName        | title                                              | bookType  | price | quantity |
      | Game of Thrones | A Game of Thrones (A Song of Ice and Fire, Book 1) | Paperback | £4.00 | 1       |
