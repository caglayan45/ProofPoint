// SPDX-License-Identifier: UNLICENSED

pragma solidity 0.8.19;

library Errors {
    error IndexCanNotBeZero(string functionName);
    error ExceptionReason(string functionName, string message);
}
