package org.web3j.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class Events extends Contract {
    public static final String BINARY = "60566037600b82828239805160001a607314602a57634e487b7160e01b600052600060045260246000fd5b30600052607381538281f3fe73000000000000000000000000000000000000000030146080604052600080fdfea26469706673582212204c4c5d4d7da0468f1aee7adb063515994c8a241b596fa0d2026c5b9e42c0222864736f6c63430008130033";

    public static final Event CREATENEWSEVENT_EVENT = new Event("CreateNewsEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event DESTROYED_EVENT = new Event("Destroyed", 
            Arrays.<TypeReference<?>>asList());
    ;

    @Deprecated
    protected Events(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Events(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Events(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Events(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public static List<DestroyedEventResponse> getDestroyedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(DESTROYED_EVENT, transactionReceipt);
        ArrayList<DestroyedEventResponse> responses = new ArrayList<DestroyedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DestroyedEventResponse typedResponse = new DestroyedEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DestroyedEventResponse> destroyedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DestroyedEventResponse>() {
            @Override
            public DestroyedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DESTROYED_EVENT, log);
                DestroyedEventResponse typedResponse = new DestroyedEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Flowable<DestroyedEventResponse> destroyedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DESTROYED_EVENT));
        return destroyedEventFlowable(filter);
    }

    @Deprecated
    public static Events load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Events(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Events load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Events(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Events load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Events(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Events load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Events(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Events> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Events.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Events> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Events.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Events> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Events.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Events> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Events.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CreateNewsEventEventResponse extends BaseEventResponse {
        public byte[] owner;

        public BigInteger index;
    }

    public static class DestroyedEventResponse extends BaseEventResponse {
    }
}
