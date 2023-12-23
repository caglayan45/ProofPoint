package org.web3j.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class NewsDataStorage extends Contract {
    public static final String BINARY = "60c0604052600a608090815269141493d3d19413d2539560b21b60a0526200002790620002b5565b6000553480156200003757600080fd5b50600180546001600160a01b0319163390811782556000908152600260209081526040808320805460ff1916851790558051610100810182528381528151808401835284815281840190815282518085018452858152828401528251808501845285815260608301528251808501845285815260808301528251808501845285815260a08301528251808501845285815260c0830152825193840190925283835260e0810192909252600480549485018155909252805160089093027f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b810193845591519092839290917f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19c909101906200015290826200037a565b50604082015160028201906200016990826200037a565b50606082015160038201906200018090826200037a565b50608082015160048201906200019790826200037a565b5060a08201516005820190620001ae90826200037a565b5060c08201516006820190620001c590826200037a565b5060e08201516007820190620001dc90826200037a565b5050600080548152600360209081526040822080546001818101835591845292829020855160089094020192835590840151849350908201906200022190826200037a565b50604082015160028201906200023890826200037a565b50606082015160038201906200024f90826200037a565b50608082015160048201906200026690826200037a565b5060a082015160058201906200027d90826200037a565b5060c082015160068201906200029490826200037a565b5060e08201516007820190620002ab90826200037a565b5050505062000446565b805160009082908203620002cc5750600092915050565b50506020015190565b634e487b7160e01b600052604160045260246000fd5b600181811c908216806200030057607f821691505b6020821081036200032157634e487b7160e01b600052602260045260246000fd5b50919050565b601f8211156200037557600081815260208120601f850160051c81016020861015620003505750805b601f850160051c820191505b8181101562000371578281556001016200035c565b5050505b505050565b81516001600160401b03811115620003965762000396620002d5565b620003ae81620003a78454620002eb565b8462000327565b602080601f831160018114620003e65760008415620003cd5750858301515b600019600386901b1c1916600185901b17855562000371565b600085815260208120601f198616915b828110156200041757888601518255948401946001909101908401620003f6565b5085821015620004365787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b6113c080620004566000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c8063893d20e81161005b578063893d20e8146100e7578063b0e31f1314610102578063c4a85bc114610115578063d193d4b81461012857600080fd5b80635afa34db1461008257806361afd5ac146100b25780637a46c293146100c7575b600080fd5b610095610090366004610ded565b610149565b6040516100a9989796959493929190610e4c565b60405180910390f35b6100c56100c0366004610eed565b610555565b005b6100da6100d5366004610ded565b6105c2565b6040516100a99190610f1d565b6001546040516001600160a01b0390911681526020016100a9565b610095610110366004610fff565b610aa0565b6100c5610123366004610eed565b610ae6565b61013b6101363660046110c4565b610b51565b6040519081526020016100a9565b6004818154811061015957600080fd5b6000918252602090912060089091020180546001820180549193509061017e90611204565b80601f01602080910402602001604051908101604052809291908181526020018280546101aa90611204565b80156101f75780601f106101cc576101008083540402835291602001916101f7565b820191906000526020600020905b8154815290600101906020018083116101da57829003601f168201915b50505050509080600201805461020c90611204565b80601f016020809104026020016040519081016040528092919081815260200182805461023890611204565b80156102855780601f1061025a57610100808354040283529160200191610285565b820191906000526020600020905b81548152906001019060200180831161026857829003601f168201915b50505050509080600301805461029a90611204565b80601f01602080910402602001604051908101604052809291908181526020018280546102c690611204565b80156103135780601f106102e857610100808354040283529160200191610313565b820191906000526020600020905b8154815290600101906020018083116102f657829003601f168201915b50505050509080600401805461032890611204565b80601f016020809104026020016040519081016040528092919081815260200182805461035490611204565b80156103a15780601f10610376576101008083540402835291602001916103a1565b820191906000526020600020905b81548152906001019060200180831161038457829003601f168201915b5050505050908060050180546103b690611204565b80601f01602080910402602001604051908101604052809291908181526020018280546103e290611204565b801561042f5780601f106104045761010080835404028352916020019161042f565b820191906000526020600020905b81548152906001019060200180831161041257829003601f168201915b50505050509080600601805461044490611204565b80601f016020809104026020016040519081016040528092919081815260200182805461047090611204565b80156104bd5780601f10610492576101008083540402835291602001916104bd565b820191906000526020600020905b8154815290600101906020018083116104a057829003601f168201915b5050505050908060070180546104d290611204565b80601f01602080910402602001604051908101604052809291908181526020018280546104fe90611204565b801561054b5780601f106105205761010080835404028352916020019161054b565b820191906000526020600020905b81548152906001019060200180831161052e57829003601f168201915b5050505050905088565b6001546001600160a01b031633146105a15760405162461bcd60e51b815260206004820152600a60248201526927b7363c9037bbb732b960b11b60448201526064015b60405180910390fd5b6001600160a01b03166000908152600260205260409020805460ff19169055565b61060a60405180610100016040528060008152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001606081525090565b3360009081526002602052604090205460ff1615156001146106645760405162461bcd60e51b815260206004820152601360248201527213db9b1e481858d8d95cdcc8185b1b1bddd959606a1b6044820152606401610598565b600482815481106106775761067761123e565b906000526020600020906008020160405180610100016040529081600082015481526020016001820180546106ab90611204565b80601f01602080910402602001604051908101604052809291908181526020018280546106d790611204565b80156107245780601f106106f957610100808354040283529160200191610724565b820191906000526020600020905b81548152906001019060200180831161070757829003601f168201915b5050505050815260200160028201805461073d90611204565b80601f016020809104026020016040519081016040528092919081815260200182805461076990611204565b80156107b65780601f1061078b576101008083540402835291602001916107b6565b820191906000526020600020905b81548152906001019060200180831161079957829003601f168201915b505050505081526020016003820180546107cf90611204565b80601f01602080910402602001604051908101604052809291908181526020018280546107fb90611204565b80156108485780601f1061081d57610100808354040283529160200191610848565b820191906000526020600020905b81548152906001019060200180831161082b57829003601f168201915b5050505050815260200160048201805461086190611204565b80601f016020809104026020016040519081016040528092919081815260200182805461088d90611204565b80156108da5780601f106108af576101008083540402835291602001916108da565b820191906000526020600020905b8154815290600101906020018083116108bd57829003601f168201915b505050505081526020016005820180546108f390611204565b80601f016020809104026020016040519081016040528092919081815260200182805461091f90611204565b801561096c5780601f106109415761010080835404028352916020019161096c565b820191906000526020600020905b81548152906001019060200180831161094f57829003601f168201915b5050505050815260200160068201805461098590611204565b80601f01602080910402602001604051908101604052809291908181526020018280546109b190611204565b80156109fe5780601f106109d3576101008083540402835291602001916109fe565b820191906000526020600020905b8154815290600101906020018083116109e157829003601f168201915b50505050508152602001600782018054610a1790611204565b80601f0160208091040260200160405190810160405280929190818152602001828054610a4390611204565b8015610a905780601f10610a6557610100808354040283529160200191610a90565b820191906000526020600020905b815481529060010190602001808311610a7357829003601f168201915b5050505050815250509050919050565b60036020528160005260406000208181548110610abc57600080fd5b90600052602060002090600802016000915091505080600001549080600101805461017e90611204565b6001546001600160a01b03163314610b2d5760405162461bcd60e51b815260206004820152600a60248201526927b7363c9037bbb732b960b11b6044820152606401610598565b6001600160a01b03166000908152600260205260409020805460ff19166001179055565b3360009081526002602052604081205460ff161515600114610bab5760405162461bcd60e51b815260206004820152601360248201527213db9b1e481858d8d95cdcc8185b1b1bddd959606a1b6044820152606401610598565b600060405180610100016040528060048054905081526020018a815260200189815260200188815260200187815260200186815260200185815260200184815250905060036000610bfb8b610dce565b81526020808201929092526040016000908120805460018181018355918352918390208451600890930201918255918301518392820190610c3c90826112a3565b5060408201516002820190610c5190826112a3565b5060608201516003820190610c6690826112a3565b5060808201516004820190610c7b90826112a3565b5060a08201516005820190610c9090826112a3565b5060c08201516006820190610ca590826112a3565b5060e08201516007820190610cba90826112a3565b505060048054600181018255600091909152825160089091027f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b810191825560208401518493507f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19c90910190610d3090826112a3565b5060408201516002820190610d4590826112a3565b5060608201516003820190610d5a90826112a3565b5060808201516004820190610d6f90826112a3565b5060a08201516005820190610d8490826112a3565b5060c08201516006820190610d9990826112a3565b5060e08201516007820190610dae90826112a3565b5050600454610dc09150600190611363565b9a9950505050505050505050565b805160009082908203610de45750600092915050565b50506020015190565b600060208284031215610dff57600080fd5b5035919050565b6000815180845260005b81811015610e2c57602081850181015186830182015201610e10565b506000602082860101526020601f19601f83011685010191505092915050565b60006101008a8352806020840152610e668184018b610e06565b90508281036040840152610e7a818a610e06565b90508281036060840152610e8e8189610e06565b90508281036080840152610ea28188610e06565b905082810360a0840152610eb68187610e06565b905082810360c0840152610eca8186610e06565b905082810360e0840152610ede8185610e06565b9b9a5050505050505050505050565b600060208284031215610eff57600080fd5b81356001600160a01b0381168114610f1657600080fd5b9392505050565b602081528151602082015260006020830151610100806040850152610f46610120850183610e06565b91506040850151601f1980868503016060870152610f648483610e06565b93506060870151915080868503016080870152610f818483610e06565b935060808701519150808685030160a0870152610f9e8483610e06565b935060a08701519150808685030160c0870152610fbb8483610e06565b935060c08701519150808685030160e0870152610fd88483610e06565b935060e0870151915080868503018387015250610ff58382610e06565b9695505050505050565b6000806040838503121561101257600080fd5b50508035926020909101359150565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261104857600080fd5b813567ffffffffffffffff8082111561106357611063611021565b604051601f8301601f19908116603f0116810190828211818310171561108b5761108b611021565b816040528381528660208588010111156110a457600080fd5b836020870160208301376000602085830101528094505050505092915050565b600080600080600080600080610100898b0312156110e157600080fd5b883567ffffffffffffffff808211156110f957600080fd5b6111058c838d01611037565b995060208b013591508082111561111b57600080fd5b6111278c838d01611037565b985060408b013591508082111561113d57600080fd5b6111498c838d01611037565b975060608b013591508082111561115f57600080fd5b61116b8c838d01611037565b965060808b013591508082111561118157600080fd5b61118d8c838d01611037565b955060a08b01359150808211156111a357600080fd5b6111af8c838d01611037565b945060c08b01359150808211156111c557600080fd5b6111d18c838d01611037565b935060e08b01359150808211156111e757600080fd5b506111f48b828c01611037565b9150509295985092959890939650565b600181811c9082168061121857607f821691505b60208210810361123857634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052603260045260246000fd5b601f82111561129e57600081815260208120601f850160051c8101602086101561127b5750805b601f850160051c820191505b8181101561129a57828155600101611287565b5050505b505050565b815167ffffffffffffffff8111156112bd576112bd611021565b6112d1816112cb8454611204565b84611254565b602080601f83116001811461130657600084156112ee5750858301515b600019600386901b1c1916600185901b17855561129a565b600085815260208120601f198616915b8281101561133557888601518255948401946001909101908401611316565b50858210156113535787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b8181038181111561138457634e487b7160e01b600052601160045260246000fd5b9291505056fea264697066735822122075481f758b1e2da6de30e790f80964875d268f2471467300b603f8431183510e64736f6c63430008130033";

    public static final String FUNC_ALLOWACCESS = "allowAccess";

    public static final String FUNC_CREATENEWS = "createNews";

    public static final String FUNC_DENYACCESS = "denyAccess";

    public static final String FUNC_GETNEWSBYINDEX = "getNewsByIndex";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_NEWS = "news";

    public static final String FUNC_OWNER_NEWS = "owner_news";

    @Deprecated
    protected NewsDataStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected NewsDataStorage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected NewsDataStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected NewsDataStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> allowAccess(String _address) {
        final Function function = new Function(
                FUNC_ALLOWACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> createNews(String _newsId, String _newsOwner, String _newsType, String _newsTypeCategory, String _title, String _description, String _content, String _author) {
        final Function function = new Function(
                FUNC_CREATENEWS, 
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

    public RemoteFunctionCall<TransactionReceipt> denyAccess(String _address) {
        final Function function = new Function(
                FUNC_DENYACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<NewsStruct> getNewsByIndex(BigInteger _index) {
        final Function function = new Function(FUNC_GETNEWSBYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<NewsStruct>() {}));
        return executeRemoteCallSingleValueReturn(function, NewsStruct.class);
    }

    public RemoteFunctionCall<String> getOwner() {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple8<BigInteger, String, String, String, String, String, String, String>> news(BigInteger param0) {
        final Function function = new Function(FUNC_NEWS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
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

    public RemoteFunctionCall<Tuple8<BigInteger, String, String, String, String, String, String, String>> owner_news(byte[] param0, BigInteger param1) {
        final Function function = new Function(FUNC_OWNER_NEWS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
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

    @Deprecated
    public static NewsDataStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new NewsDataStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static NewsDataStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new NewsDataStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static NewsDataStorage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new NewsDataStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static NewsDataStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new NewsDataStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<NewsDataStorage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(NewsDataStorage.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<NewsDataStorage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(NewsDataStorage.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<NewsDataStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(NewsDataStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<NewsDataStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(NewsDataStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class NewsStruct extends DynamicStruct {
        public BigInteger id;

        public String owner;

        public String newsType;

        public String newsTypeCategory;

        public String title;

        public String description;

        public String content;

        public String author;

        public NewsStruct(BigInteger id, String owner, String newsType, String newsTypeCategory, String title, String description, String content, String author) {
            super(new org.web3j.abi.datatypes.generated.Uint256(id), 
                    new org.web3j.abi.datatypes.Utf8String(owner), 
                    new org.web3j.abi.datatypes.Utf8String(newsType), 
                    new org.web3j.abi.datatypes.Utf8String(newsTypeCategory), 
                    new org.web3j.abi.datatypes.Utf8String(title), 
                    new org.web3j.abi.datatypes.Utf8String(description), 
                    new org.web3j.abi.datatypes.Utf8String(content), 
                    new org.web3j.abi.datatypes.Utf8String(author));
            this.id = id;
            this.owner = owner;
            this.newsType = newsType;
            this.newsTypeCategory = newsTypeCategory;
            this.title = title;
            this.description = description;
            this.content = content;
            this.author = author;
        }

        public NewsStruct(Uint256 id, Utf8String owner, Utf8String newsType, Utf8String newsTypeCategory, Utf8String title, Utf8String description, Utf8String content, Utf8String author) {
            super(id, owner, newsType, newsTypeCategory, title, description, content, author);
            this.id = id.getValue();
            this.owner = owner.getValue();
            this.newsType = newsType.getValue();
            this.newsTypeCategory = newsTypeCategory.getValue();
            this.title = title.getValue();
            this.description = description.getValue();
            this.content = content.getValue();
            this.author = author.getValue();
        }
    }
}
