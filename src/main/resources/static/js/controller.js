

appname.controller('PostsCtrl', ['$scope', function($scope){
    // Here the array would be your response.text:
    $scope.names = ['John', 'Jessie', 'Johanna', 'Joy', 'Mary', 'Peter', 'Sebastian', 'Erika', 'Patrick', 'Samantha'];

}]);

appname.controller('AppController', ['$scope', function($scope){

(function(angular) {
  var AppController = function($scope, Movie) {
    Movie.query(function(response) {
      $scope.movies = response ? response : [];
    });
    

    
  };
  
  AppController.$inject = ['$scope', 'Movie'];
  angular.module("appname.controllers").controller("AppController", AppController);
}(angular));