// SPDX-License-Identifier: UNLICENSED

pragma solidity 0.8.19;

library Structs {

    struct NewsStruct {
        uint256 id;
        string owner;
        string newsType;
        string newsTypeCategory;
        string title;
        string description;
        string content;
        string author;
    }
}
