#include <iostream>
#include <fstream>
#include <string>


using namespace std;


int main()
{
    char ch;
    
    //file names
    string input = "infile.txt";
    string output = "outfile.txt";
    
    //opens if/of streams
    ifstream inStream(input);
    ofstream outStream(output);
    
    //checks if it can be opeened
    if(!inStream){
        std:: cout << input << " not found... file opening failed" << endl;
        return 0;
    }
    
    //adding pre
    outStream.put('<');
    outStream.put('P');
    outStream.put('R');
    outStream.put('E');
    outStream.put('>');
    outStream.put('\n');

    inStream.get(ch);
    

    //loops thorugh ifstream doc
    while(!inStream.eof()){
        outStream.setf(ios::fixed);
    }
        
        //checks for <
        if(ch == '<'){
            outStream.put('&');
            outStream.put('l');
            outStream.put('t');
            outStream.put(';');
        }
        //checks for >
        else if(ch == '>'){
            outStream.put('&');
            outStream.put('g');
            outStream.put('t');
            outStream.put(';');
        }
        else{
            outStream.put(ch);
        }
        
        inStream.get(ch);
        //pre at the end
        outStream.put('\n');
        outStream.put('<');
        outStream.put('/');
        outStream.put('P');
        outStream.put('R');
        outStream.put('E');
        outStream.put('>');
        outStream.put('\n');
        
        inStream.close();
        outStream.close();
        return 0;
}
