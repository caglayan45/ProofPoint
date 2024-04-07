// SPDX-License-Identifier: UNLICENSED

pragma solidity 0.8.19;

import {Errors} from "./Libraries/ErrorsV3.sol";
import {Events} from "./Libraries/EventsV3.sol";
import {Strings} from "./Libraries/StringsV3.sol";
import {Structs} from "./Libraries/StructsV3.sol";
import {NewsDataStorage} from "./NewsDataStorage.sol";

contract NewsContract {
    using Errors for *;
    using Events for *;
    using Strings for *;
    using Structs for *;

    NewsDataStorage newsDataStorage;
    address public owner;

    modifier onlyOwner() {
        require(msg.sender == owner, "Only owner");
        _;
    }
    constructor(address _storageAddress) {
        owner = msg.sender;
        newsDataStorage = NewsDataStorage(_storageAddress);
    }

    event CreateNewsEvent(
        string indexed owner,
        uint256 indexed index
    );

    function setStorageContract(address _storageAddress) public {
        newsDataStorage = NewsDataStorage(_storageAddress);
    }

    function createNewsWithData(
        string memory _newsId,
        string memory _newsOwner,
        string memory _newsType,
        string memory _newsTypeCategory,
        string memory _title,
        string memory _description,
        string memory _content,
        string memory _author
    ) external onlyOwner returns (uint256) {
        string memory functionName = "createNewsWithData";

        try
        newsDataStorage.createNews(
            _newsId,
            _newsOwner,
            _newsType,
            _newsTypeCategory,
            _title,
            _description,
            _content,
            _author
        )
        returns (uint256 _index)
        {
            emit CreateNewsEvent(_newsOwner, _index);
            return _index;
        } catch Error(string memory reason) {
            revert Errors.ExceptionReason(functionName, reason);
        } catch {
            revert Errors.ExceptionReason(functionName, "Unknown error");
        }
    }

    function getNews(uint256 _index)
    public
    view
    returns (
        uint256 id,
        string memory newsOwner,
        string memory newsType,
        string memory newsTypeCategory,
        string memory title,
        string memory description,
        string memory content,
        string memory author
    )
    {
        string memory functionName = "getNews";
        try
        newsDataStorage.getNewsByIndex(_index)
        returns (Structs.NewsStruct memory _news) {
            return (
                _news.id,
                _news.owner,
                _news.newsType,
                _news.newsTypeCategory,
                _news.title,
                _news.description,
                _news.content,
                _news.author
            );
        } catch Error(string memory reason) {
            revert Errors.ExceptionReason(functionName, reason);
        }

    }
}
