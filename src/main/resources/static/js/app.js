
(function(angular) {
  angular.module("myApp.controllers", []);
  angular.module("myApp.services", []);
  angular.module("myApp", ["ngResource", "ngRoute", "spring-data-rest", "myApp.controllers", "myApp.services"]);
}(angular));