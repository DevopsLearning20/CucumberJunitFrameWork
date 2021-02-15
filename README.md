# CucumberJunitFrameWork

Introduction about framework - 
I used a page object model design pattern approach  in the framework. Main advantage of this framework is it is easy to maintain.This framework  is developed  using  Maven,Cucumber, Java,Junit, selenium, extent Report,CucumberReport , Log4J.
Framework divided in various layers of packages which is having their single responsibility.
1. Feature Layer - In this package test cases written in GHERKIN language, login feature and career feature file is created based on that execution will handle it is tagged with different tags using tag we can execute any flow with the help of test runner.
2. Page Layer - Page layer placed in the main folder of maven, we consider each page as each page class, In that we mentioned the WebElement path and actions of the page and each Webelement is encapsulated with actions.
3. Steps layer  - Steps Layer placed in maven test folder, each class created based on page layer. Responsibility of the step layer is verifications of actions which are written in page layers  using JUNIT or TestNG any library we can use here. 
4. Driver factory - This package responsible for driver invocation. Thread local concept is used to manage to invoke a single driver instance. which helps to manage synchronization during parallel execution of test cases. 
5. Config Layers - This package responsible for all configuration of the project. I maintained Report configurations, Project configuration, Environment Configuration.
6. Util layers - This package responsible for helper methods for read configurations, Manage constant, Wrapper methods.
7. Test Runner - This package is responsible for execution, various setting tagged based execution is managed  from test runner. 
8. Resources - All files which are help for upload, Excel for test data reading, all project resources managed from here.
9. Test output - All execution reports stores in this folder.
10. Constant layer - All constant managed in this class.
11. Logger Layer - LOG4J used for maintain execution logs.
