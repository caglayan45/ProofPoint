// SPDX-License-Identifier: UNLICENSED

pragma solidity 0.8.19;

library Events {
    event CreateNewsEvent(
        string indexed owner,
        uint256 indexed index
    );

    event Destroyed();
}
