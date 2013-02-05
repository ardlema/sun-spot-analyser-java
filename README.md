  The problem
  -----------
  
  NASA wishes to analyse areas of the Sun for thermal activity. Their sensors provide raw data which can visualised as a n by n grid of raw heat measurements that represent the Sun's surface. In the raw data the range of measurements will always range from 0 (low heat) to 5 (high heat). This data needs to be analysed to find likely areas of increased solar activity. The analysis consists of generating an Solar Activity Score for each location on the grid. The score is determined by adding the location's own raw heat value to its surrounding raw heat values. For instance, the score of location (1,1) is as follows: 5 + 3 + 1 + 4 + 1 + 1 + 2 + 3 + 2 = 22 When dealing with locations around the edge of the grid the score should ignore values outside the grid. For instance the score of location (0,0) is as follows: 5 + 3 + 4 + 1 = 13 The required output of the analysis is to provide an ordered list of locations containing the t number of highest rated locations and their respective scores. Input and Output

The input provided to the analyser will be in the form of a list of numbers: t n Grid 1 3 4 2 3 2 2 1 3 2 1

Where t is the number of results requested, n is the size of the grid and grid is a space delimited list of numbers that form the grid, starting with row 0. The list of numbers above therefore represent a request for the single top score from a 3x3 grid that looks like so: 4 2 3 2 2 1 3 2 1

Output should be a list of locations and their scores in the following form: (x,y score:score) i.e. the result that should be returned for the above input is: (1,1 score:20)

  The solution
  ------------
  
  This distribution provides a solution to the Sun Spot Analyser Problem.

  Although the application has been coded following the TDD methodology (see the
  SunSpotAnalyserImplTest class within the sunspotanalyser project) the distribution
  includes two clients (see sun-spot-analyser-client-java) to test the solution.

  
  System Requirements
  -------------------

  Operating System:

    The solution has been coded in Java so it runs fine on Windows, Linux and Mac OS.

  Maven installed

  JDK/JRE installed


  Installing Sun Spot Analyser
  ----------------------------

  1) Clone the repo and execute the following commands: 

         mvn install
         mvn dependency:copy-dependencies


  5) Then clone the sun-spot-analyser-client-java repo and follow the instructions within that repo README file
