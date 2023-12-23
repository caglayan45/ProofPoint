// SPDX-License-Identifier: UNLICENSED

pragma solidity 0.8.19;

import {Strings} from "./Libraries/StringsV3.sol";
import {Structs} from "./Libraries/StructsV3.sol";

contract NewsDataStorage {

    using Strings for *;
    using Structs for *;
    bytes32 private _proofPoint = Strings.stringToBytes32("PROOFPOINT");
    address private owner;

    mapping(address => bool) accessAllowed;

    modifier onlyOwner() {
        require(msg.sender == owner, "Only owner");
        _;
    }
    modifier onlyAccessAllowed() {
        require(accessAllowed[msg.sender] == true, "Only access allowed");
        _;
    }

    function allowAccess(address _address) public onlyOwner {
        accessAllowed[_address] = true;
    }

    function denyAccess(address _address) public onlyOwner {
        accessAllowed[_address] = false;
    }

    // bytes32 = owner
    mapping(bytes32 => Structs.NewsStruct[]) public owner_news;

    Structs.NewsStruct[] public news;

    constructor() {
        owner = msg.sender;
        accessAllowed[msg.sender] = true;

        Structs.NewsStruct memory initialNews = Structs.NewsStruct({
            id: 0,
            owner: "",
            newsType: "",
            newsTypeCategory: "",
            title: "",
            description: "",
            content: "",
            author: ""
        });
        news.push(initialNews);
        owner_news[_proofPoint].push(initialNews);
    }

    function getOwner() external view returns (address) {
        return owner;
    }


    function createNews(
        string memory _newsId,
        string memory _newsOwner,
        string memory _newsType,
        string memory _newsTypeCategory,
        string memory _title,
        string memory _description,
        string memory _content,
        string memory _author) external onlyAccessAllowed returns (uint256 _index) {
        Structs.NewsStruct memory record = Structs
            .NewsStruct({
            id: news.length,
            owner: _newsOwner,
            newsType: _newsType,
            newsTypeCategory: _newsTypeCategory,
            title: _title,
            description: _description,
            content: _content,
            author: _author
        });
        owner_news[Strings.stringToBytes32(_newsOwner)].push(record);
        news.push(record);
        _index = news.length - 1;
    }


    function getNewsByIndex(uint256 _index)
    external
    onlyAccessAllowed
    view
    returns (Structs.NewsStruct memory)
    {
        return (news[_index]);
    }

}
