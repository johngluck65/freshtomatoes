(function(angular) {
  var AppController = function($scope, Movie) {
    Movie.query(function(response) {
      $scope.movies = response ? response : [];
    });
    
    $scope.addMovie = function(description) {
      new Movie({
        description: description,
        checked: false
      }).save(function(movie) {
        $scope.movies.push(movie);
      });
      $scope.newMovie = "";
    };
    
    $scope.updateMovie = function(movie) {
      movie.save();
    };
    
    $scope.deleteMovie = function(movie) {
      movie.remove(function() {
        $scope.movies.splice($scope.movies.indexOf(movie), 1);
      });
    };
  };
  
  AppController.$inject = ['$scope', 'Movie'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));