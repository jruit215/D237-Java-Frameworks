<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS

### C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
**mainscreen.html:**
- Changed the title name (line 14)
- added inline styling to body tag (line 16)
- Changed the shop name and added divs (line 18-23)

### D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
- Created templates/about.html file.
- Added content to about.html, and created a button to navigate back to mainscreen.html (lines 17-23)
- Created a GetMapping for the About page in MainScreenControllerr.java (lines 56-59).
- Added a div container with a button linking to about.html in mainscreen.html (lines 23-25)

### E.  Add a sample inventory appropriate for your chosen store to the application.
**MainScreenControllerr.java:**
- Added if/else to check if there are 5 parts already added, else this sample inventory gets added (lines 50-95)
- Added if/else to check if there are 5 products already added, else this sample inventory gets added (lines 100-140)
### F.  Add a “Buy Now” button to your product list.
**mainscreen.html:**
- Added a "Buy Now" button (line 93)

**repositories/ProductRepository.java:**
- Added @Query findByOne for theId (line 20-21)

**service/ProductService.java:**
- Added boolean for theId (line 20)

**service/ProductServiceImpl:**
- Added decremental functionality for "Buy Now" button (line 71-83)

**Templates folder:**
- Created success.html for successful purchase
- Created failure.html for purchase failure

**MainScreenControllerr.java:**
- Added @GetMapping for the success/failure of the "Buy Now" button, showing the according page

### G.  Modify the parts to track maximum and minimum inventory by doing the following:
**Part.java:**
- Added additional fields for maximum and minimum inventory (line 31-32, 87-101)

**MainScreenControllerr.java:**
- Added sample min & max fields to the parts in sample inventory (line 55-88)

### H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:


### I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.


### J. Remove class files for any unused validators in order to clean your code.

