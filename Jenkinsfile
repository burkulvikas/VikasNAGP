node{
    try{
        stage('CheckOutCode'){

            echo 'Cloning the code from Git repo'
            git branch: 'master',url:'https://github.com/burkulvikas/VikasNAGP.git'

        }
        stage('Test'){

            echo 'Testing the test cases'
            bat 'mvn clean test'

        }

        echo 'Build has been success!!!'

    }catch(Exception e){

        echo 'Build got failed'

    }finally{

        echo 'this block is execute always'

    }
}