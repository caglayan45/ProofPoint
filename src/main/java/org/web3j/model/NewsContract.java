package org.web3j.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
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
public class NewsContract extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50604051610b0c380380610b0c83398101604081905261002f91610062565b60018054336001600160a01b031991821617909155600080549091166001600160a01b0392909216919091179055610092565b60006020828403121561007457600080fd5b81516001600160a01b038116811461008b57600080fd5b9392505050565b610a6b806100a16000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80630dfa8ffe146100515780638da5cb5b14610077578063ba53911b146100a2578063dc38b0a2146100c9575b600080fd5b61006461005f3660046104a9565b6100fb565b6040519081526020015b60405180910390f35b60015461008a906001600160a01b031681565b6040516001600160a01b03909116815260200161006e565b6100b56100b03660046105e9565b6102a3565b60405161006e989796959493929190610652565b6100f96100d73660046106f3565b600080546001600160a01b0319166001600160a01b0392909216919091179055565b005b6001546000906001600160a01b0316331461014a5760405162461bcd60e51b815260206004820152600a60248201526927b7363c9037bbb732b960b11b60448201526064015b60405180910390fd5b60408051808201825260128152716372656174654e657773576974684461746160701b60208201526000549151631a327a9760e31b815290916001600160a01b03169063d193d4b8906101af908d908d908d908d908d908d908d908d90600401610723565b6020604051808303816000875af19250505080156101ea575060408051601f3d908101601f191682019092526101e79181019061074b565b60015b61024f576101f6610764565b806308c379a003610232575061020a610780565b806102155750610234565b81816040516308316b1360e31b815260040161014192919061080a565b505b806040516308316b1360e31b81526004016101419190610838565b808a60405161025e919061087a565b604051908190038120907fed4c7d9d4f214494b30e539d3d6e919444f3bbb3d3c89e9a9adf2f54e9f20dea90600090a391506102979050565b98975050505050505050565b60408051808201825260078152666765744e65777360c81b6020820152600080549251637a46c29360e01b8152600481018590529092606092839283928392839283928392916001600160a01b0390911690637a46c29390602401600060405180830381865afa92505050801561033c57506040513d6000823e601f3d908101601f1916820160405261033991908101906108e5565b60015b61037357610348610764565b806308c379a003610367575061035c610780565b806102155750610369565b505b3d6000803e3d6000fd5b806000015181602001518260400151836060015184608001518560a001518660c001518760e00151995099509950995099509950995099505050919395975091939597565b634e487b7160e01b600052604160045260246000fd5b601f8201601f1916810167ffffffffffffffff811182821017156103f4576103f46103b8565b6040525050565b604051610100810167ffffffffffffffff8111828210171561041f5761041f6103b8565b60405290565b600067ffffffffffffffff82111561043f5761043f6103b8565b50601f01601f191660200190565b600082601f83011261045e57600080fd5b813561046981610425565b60405161047682826103ce565b82815285602084870101111561048b57600080fd5b82602086016020830137600092810160200192909252509392505050565b600080600080600080600080610100898b0312156104c657600080fd5b883567ffffffffffffffff808211156104de57600080fd5b6104ea8c838d0161044d565b995060208b013591508082111561050057600080fd5b61050c8c838d0161044d565b985060408b013591508082111561052257600080fd5b61052e8c838d0161044d565b975060608b013591508082111561054457600080fd5b6105508c838d0161044d565b965060808b013591508082111561056657600080fd5b6105728c838d0161044d565b955060a08b013591508082111561058857600080fd5b6105948c838d0161044d565b945060c08b01359150808211156105aa57600080fd5b6105b68c838d0161044d565b935060e08b01359150808211156105cc57600080fd5b506105d98b828c0161044d565b9150509295985092959890939650565b6000602082840312156105fb57600080fd5b5035919050565b60005b8381101561061d578181015183820152602001610605565b50506000910152565b6000815180845261063e816020860160208601610602565b601f01601f19169290920160200192915050565b60006101008a835280602084015261066c8184018b610626565b90508281036040840152610680818a610626565b905082810360608401526106948189610626565b905082810360808401526106a88188610626565b905082810360a08401526106bc8187610626565b905082810360c08401526106d08186610626565b905082810360e08401526106e48185610626565b9b9a5050505050505050505050565b60006020828403121561070557600080fd5b81356001600160a01b038116811461071c57600080fd5b9392505050565b60006101008083526107378184018c610626565b9050828103602084015261066c818b610626565b60006020828403121561075d57600080fd5b5051919050565b600060033d111561077d5760046000803e5060005160e01c5b90565b600060443d101561078e5790565b6040516003193d81016004833e81513d67ffffffffffffffff81602484011181841117156107be57505050505090565b82850191508151818111156107d65750505050505090565b843d87010160208285010111156107f05750505050505090565b6107ff602082860101876103ce565b509095945050505050565b60408152600061081d6040830185610626565b828103602084015261082f8185610626565b95945050505050565b60408152600061084b6040830184610626565b8281036020840152600d81526c2ab735b737bbb71032b93937b960991b60208201526040810191505092915050565b6000825161088c818460208701610602565b9190910192915050565b600082601f8301126108a757600080fd5b81516108b281610425565b6040516108bf82826103ce565b8281528560208487010111156108d457600080fd5b61082f836020830160208801610602565b6000602082840312156108f757600080fd5b815167ffffffffffffffff8082111561090f57600080fd5b90830190610100828603121561092457600080fd5b61092c6103fb565b8251815260208301518281111561094257600080fd5b61094e87828601610896565b60208301525060408301518281111561096657600080fd5b61097287828601610896565b60408301525060608301518281111561098a57600080fd5b61099687828601610896565b6060830152506080830151828111156109ae57600080fd5b6109ba87828601610896565b60808301525060a0830151828111156109d257600080fd5b6109de87828601610896565b60a08301525060c0830151828111156109f657600080fd5b610a0287828601610896565b60c08301525060e083015182811115610a1a57600080fd5b610a2687828601610896565b60e0830152509594505050505056fea2646970667358221220e91bc2d2fc1edfecd9fa13a007202e9c58e7d95608f4698864e46b329340b66864736f6c63430008130033";

    public static final String FUNC_CREATENEWSWITHDATA = "createNewsWithData";

    public static final String FUNC_GETNEWS = "getNews";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SETSTORAGECONTRACT = "setStorageContract";

    public static final Event CREATENEWSEVENT_EVENT = new Event("CreateNewsEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected NewsContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected NewsContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected NewsContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected NewsContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<CreateNewsEventEventResponse> getCreateNewsEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CREATENEWSEVENT_EVENT, transactionReceipt);
        ArrayList<CreateNewsEventEventResponse> responses = new ArrayList<CreateNewsEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CreateNewsEventEventResponse typedResponse = new CreateNewsEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CreateNewsEventEventResponse> createNewsEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CreateNewsEventEventResponse>() {
            @Override
            public CreateNewsEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CREATENEWSEVENT_EVENT, log);
                CreateNewsEventEventResponse typedResponse = new CreateNewsEventEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CreateNewsEventEventResponse> createNewsEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CREATENEWSEVENT_EVENT));
        return createNewsEventEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> createNewsWithData(String _newsId, String _newsOwner, String _newsType, String _newsTypeCategory, String _title, String _description, String _content, String _author) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATENEWSWITHDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_newsId), 
                new org.web3j.abi.datatypes.Utf8String(_newsOwner), 
                new org.web3j.abi.datatypes.Utf8String(_newsType), 
                new org.web3j.abi.datatypes.Utf8String(_newsTypeCategory), 
                new org.web3j.abi.datatypes.Utf8String(_title), 
                new org.web3j.abi.datatypes.Utf8String(_description), 
                new org.web3j.abi.datatypes.Utf8String(_content), 
                new org.web3j.abi.datatypes.Utf8String(_author)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple8<BigInteger, String, String, String, String, String, String, String>> getNews(BigInteger _index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETNEWS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple8<BigInteger, String, String, String, String, String, String, String>>(function,
                new Callable<Tuple8<BigInteger, String, String, String, String, String, String, String>>() {
                    @Override
                    public Tuple8<BigInteger, String, String, String, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, String, String, String, String, String, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (String) results.get(7).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setStorageContract(String _storageAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETSTORAGECONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _storageAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static NewsContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new NewsContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static NewsContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new NewsContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static NewsContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new NewsContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static NewsContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new NewsContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<NewsContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _storageAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _storageAddress)));
        return deployRemoteCall(NewsContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<NewsContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _storageAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _storageAddress)));
        return deployRemoteCall(NewsContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<NewsContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _storageAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _storageAddress)));
        return deployRemoteCall(NewsContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<NewsContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _storageAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _storageAddress)));
        return deployRemoteCall(NewsContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class CreateNewsEventEventResponse extends BaseEventResponse {
        public byte[] owner;

        public BigInteger index;
    }
}
