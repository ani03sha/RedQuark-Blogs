# Bulk User Creation

Sometimes it so happens that we need to create many users in the AEM and to add them in a desired group. We can do this in AEM Useradmin console manually. But this process is tedious and inefficient. 

In most of the cases, we get the users in a file with their details (firstname, lastname, username, group, email, password etc.). Wouldn't it be easier if we just upload the file in our AEM instance and the users are created in the AEM server automatically?

Therefore, I decided to create an AEM project that does exactly that. In this project, a user can go to a custom console that is created and upload an excel file with the details of the users.

## Steps to configure

For this, you can refer to my blog - [Create users in AEM from excel file](https://aem.redquark.org/2019/05/create-users-in-aem-from-excel-file.html).

## How does it work?

Here, we are creating following things -
1. Custom console in the "Tools" menu of the AEM server
2. Apache POI utility service reads the excel file and create a list containing all the users with their details.
3. The list creates is then passed to the user creation service which then creates users one by one using **org.apache.jackrabbit.api.security.user.UserManager** API.

## Issues

If you face any issues or problems, you are welcome to open issues. You can do this by following steps - 

* Go to the Issues tab in the repository
* Click on New issue button
* Give appropriate title to the issue
* Add detailed description of the issue and if possible, steps to reproduce
* Click on Open issue button

## How to contribute

Contributions are more than welcome in this project. Below are the steps, you can follow to contribute - 

* Switch to the 'develop' branch of the repository
* Clone the develop branch in your local system
* Make your changes
* Open a pull request against the 'develop' branch only.