package org.web3j.model;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.9.4.
 */
@SuppressWarnings("rawtypes")
public class Strings extends Contract {
    public static final String BINARY = "61029061003a600b82828239805160001a60731461002d57634e487b7160e01b600052600060045260246000fd5b30600052607381538281f3fe73000000000000000000000000000000000000000030146080604052600436106100355760003560e01c80639201de551461003a575b600080fd5b61004d61004836600461019a565b610063565b60405161005a91906101b3565b60405180910390f35b606060005b60208160ff1610801561009c5750828160ff166020811061008b5761008b610201565b1a60f81b6001600160f81b03191615155b156100b357806100ab81610217565b915050610068565b60008160ff1667ffffffffffffffff8111156100d1576100d1610244565b6040519080825280601f01601f1916602001820160405280156100fb576020820181803683370190505b509050600091505b60208260ff161080156101375750838260ff166020811061012657610126610201565b1a60f81b6001600160f81b03191615155b1561019357838260ff166020811061015157610151610201565b1a60f81b818360ff168151811061016a5761016a610201565b60200101906001600160f81b031916908160001a9053508161018b81610217565b925050610103565b9392505050565b6000602082840312156101ac57600080fd5b5035919050565b600060208083528351808285015260005b818110156101e0578581018301518582016040015282016101c4565b506000604082860101526040601f19601f8301168501019250505092915050565b634e487b7160e01b600052603260045260246000fd5b600060ff821660ff810361023b57634e487b7160e01b600052601160045260246000fd5b60010192915050565b634e487b7160e01b600052604160045260246000fdfea26469706673582212206c042c180f02f0457aba731028f0bc9d34ff15ef824ca22140955131abd1540d64736f6c63430008130033";

    public static final String FUNC_BYTES32TOSTRING = "bytes32ToString";

    @Deprecated
    protected Strings(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Strings(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Strings(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Strings(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> bytes32ToString(byte[] _bytes32) {
        final Function function = new Function(FUNC_BYTES32TOSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_bytes32)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Strings load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Strings(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Strings load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Strings(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Strings load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Strings(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Strings load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Strings(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Strings> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Strings.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Strings> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Strings.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Strings> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Strings.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Strings> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Strings.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
