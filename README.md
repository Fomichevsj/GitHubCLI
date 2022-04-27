# GitHubCLI
Clone this project
then compilie and package with maven ```mvn clean package```  
Then you will have jar with path and name like this ```/Users/user/GitHubCLI/target/GitHubCLI-1.0-SNAPSHOT-jar-with-dependencies.jar```  
It is usefull to make allias ```alias gitHubCLI='java -jar /Users/user/GitHubCLI/target/GitHubCLI-1.0-SNAPSHOT-jar-with-dependencies.jar'``` 
## How to use  
First of all, type help command ```gitHubCLI help```. You will get following output 
```
This tool is used to get some stats from Github for specific repo
This tool present the result as a table and write the output for a given
file or just print it

Usage:
GitHubCLI [-hV] [COMMAND]
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
Commands:
  downloads  will fetch the # of downloads of the entire versions +
               distributions (if exists)
  stats      will fetch the following information: stars, forks, contributors,
               language
  help       Displays help information about the specified command
  ```  
  To get more information about commands, use help for commands.  
  For `downloads`: type this ```gitHubCLI help downloads```. You will get
  ```
  Usage: GitHubCLI downloads [-hV] [-o=<filePath>] -r=<repo> [-t=<token>]
will fetch the # of downloads of the entire versions + distributions (if exists)
  -h, --help                Show this help message and exit.
  -o, --output=<filePath>   The output path of the txt file
  -r, --repo=<repo>         The repository to analyze
  -t, --token=<token>       The token for GitHub
  -V, --version             Print version information and exit.
  ```  
  And for command `stats`: type this ```gitHubCLI help stats``` and you will get
  ```
  Usage: GitHubCLI stats [-hV] [-o=<filePath>] -r=<repo> [-t=<token>]
will fetch the following information: stars, forks, contributors, language
  -h, --help                Show this help message and exit.
  -o, --output=<filePath>   The output path of the txt file
  -r, --repo=<repo>         The repository to analyze
  -t, --token=<token>       The token for GitHub
  -V, --version             Print version information and exit.
  ```
 For both commands, option ```-r``` specify name of repository. For example ```whitesource/log4j-detect-distribution```. This option is mandatory.  
 Second option ```-o``` specify output file. If this option is omitted, output will be to the std::out.  
 Also, you can specify token for your account for GitHub with option ```-t```. This can be done for avoid small limit number of request per hour.  
Token option is not mandatory. But still, its recommended to use it.  
Example of usage command ```downloads```:  
```gitHubCLI downloads -r 'whitesource/log4j-detect-distribution'```
The result will be like this:
```
_____________________________________________________________________________
| Release name       | Distribution                          | Download count|
|============================================================================|
| log4j-detect-v1.5.0| log4j-detect-1.5.0-darwin-amd64.tar.gz| 175           |
| log4j-detect-v1.5.0| log4j-detect-1.5.0-darwin-arm64.tar.gz| 20            |
| log4j-detect-v1.5.0| log4j-detect-1.5.0-linux-amd64.tar.gz | 606           |
| log4j-detect-v1.5.0| log4j-detect-1.5.0-linux-arm64.tar.gz | 43            |
                           ...
| TOTAL AMOUNT       |                                       | 4618          |
```  
If repository have no assets you would have message ```no asset for this repository```   
Example of usage command ```stats```:  
```stats -r 'whitesource/renovate-on-prem' --output "my_file.txt" --token "my_token"```  
The result will be:  
```
________________________
| stat        | value   |
|=======================|
| stars       | 80      |
| forks       | 27      |
| contributors| 17      |
| language    | Mustache|
```
