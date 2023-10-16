#ifndef jsonhandler_hpp
#define jsonhandler_hpp

#include <string>
#include <fstream>
#include <vector>
#include <typeinfo>

namespace json{
    typedef unsigned char u8;

    struct IOError{
        std::string message;
        int lineno;
        IOError(std::string message, int lineno){
            this->lineno = lineno;
            this->message = message;
        }
    };

   
    struct BadCast{

    };

    class Any{
        
    };


    struct Token{
        static const u8 STRING{0};
        static const u8 NUMBER{1};
        static const u8 ARRAY{2};
        static const u8 OBJECT{3};
        static const u8 BOOLEAN{4};

        std::string token;
        u8 type;
        static Token parse(std::string line){

        }

    };

    class JSONHandler
    {
    private:
    std::ifstream ifile;
    std::ofstream ofile;

    public:
        JSONHandler(std::string fileName, u8 mode);
        std::string dump();
        void append(std::string data);
        void parse();
        ~JSONHandler();


        static const u8 READ{0};
        static const u8 WRITE{1};
    };

}

#endif