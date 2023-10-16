#include "jsonhandler.hpp"

namespace json{

    JSONHandler::JSONHandler(std::string fileName, u8 mode){
        if(mode == JSONHandler::READ){
            ifile.open(fileName);
            if(!ifile.is_open() || ifile.peek() == ifile.eof()){
                throw new IOError("File could not be opened", __LINE__);
                ifile.close();
                return;
            }
        } else if(mode == JSONHandler::WRITE){
            ofile.open(fileName);
            if(!ofile.is_open()){
                throw new IOError("File could not be opened", __LINE__);
                ofile.close();
                return;
            }               
        }
    }


    JSONHandler::~JSONHandler(){
        ofile.close();
        ifile.close();
    }
}