#ifndef database_hpp
#define database_hpp

#include<fstream>
#include<sstream>
#include<string>
#include <vector>

namespace db
{

typedef unsigned char u8;

struct Token {
  static const u8 UNSPEC{0};
  static const u8 NO_CHILD{1};
  static const u8 ONE_CHILD{2};
  static const u8 TWO_CHILD{3};
  static const u8 THREE_CHILD{4};
  static const u8 FOUR_CHILD{5};
  u8 level;
  std::string message;
  char rawTok;
  Token(u8 level, std::string message, char rawTok) {
    this->level = level;
    this->message = message;
    this->rawTok = rawTok;
  }
  static Token parse(std::string line) {
    std::string temp;
    std::istringstream iss(line);
    char lev;
    u8 tpe;
    if (iss >> temp >> lev) {
      switch (lev) {
      case 'c':
        tpe = Token::UNSPEC;
        break;
      case '0':
        tpe = Token::NO_CHILD;
        break;
      case '1':
        tpe = Token::ONE_CHILD;
        break;
      case '2':
        tpe = Token::TWO_CHILD;
        break;
      case '3':
        tpe = Token::THREE_CHILD;
        break;
      case '4':
        tpe = Token::FOUR_CHILD;
        break;
      default:
        break;
      }
    }
    return Token(tpe, temp, lev);
  }
};

struct SortedTokens {
  std::vector<db::Token> first, second, third, fourth, none, unspec;
};

struct IOError {
  std::string message;
  IOError(std::string message, int line) {
    this->message = message;
    message.append(std::to_string(line));
  }
};

class TokenScraper {
  std::ifstream file;
  std::vector<Token> tokens;

public:
  TokenScraper(std::string filename);
  TokenScraper();
  void parseFile();
  struct SortedTokens sort();
  ~TokenScraper();
};

TokenScraper::TokenScraper(){
    file.open("tokens.tk");
    if(!file.is_open() || file.peek() == file.eof()){
        throw new IOError("Cannot open file at line", __LINE__);
        file.close();
        return;
    }
    return;
}

TokenScraper::TokenScraper(std::string filename) {
  file.open(filename);
  if (!file.is_open() || file.peek() == file.eof()) {
    throw new IOError("Cannot open file at line:", __LINE__);
    file.close();
    return;
  }
}

void TokenScraper::parseFile() {
  std::string temp;
  while (getline(file, temp)) {
    Token t = Token::parse(temp);
    tokens.push_back(t);
  }
}

TokenScraper::~TokenScraper() { file.close(); }

struct SortedTokens TokenScraper::sort() {
  SortedTokens st;
  for (int i = 0; i < tokens.size(); i++) {
    switch (tokens[i].level) {
    case Token::NO_CHILD:
      st.none.push_back(tokens[i]);
      break;
    case Token::ONE_CHILD:
      st.first.push_back(tokens[i]);
      break;
    case Token::TWO_CHILD:
      st.second.push_back(tokens[i]);
      break;
    case Token::THREE_CHILD:
      st.third.push_back(tokens[i]);
      break;
    case Token::FOUR_CHILD:
      st.fourth.push_back(tokens[i]);
      break;
    case Token::UNSPEC:
      st.unspec.push_back(tokens[i]);
      break;
    default:
      break;
    }
  }
  return st;
}


class FileGrabber{
    db::TokenScraper ts;
    SortedTokens tk;

    public:
    FileGrabber();
};

class DataBase{};

class Parser{};





} // namespace db



#endif