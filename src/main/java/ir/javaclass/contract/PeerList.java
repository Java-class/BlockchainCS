package ir.javaclass.contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple11;
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
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class PeerList extends Contract {
    private static final String BINARY = "60806040526000805534801561001457600080fd5b50611836806100246000396000f3fe608060405234801561001057600080fd5b50600436106100ea5760003560e01c8063cbe5046b1161008c578063e0d4f1c311610066578063e0d4f1c314610878578063e2091070146108d4578063e81ea5951461091a578063f3a0786114610938576100ea565b8063cbe5046b14610719578063cf9f95e9146107ec578063d9e38b7314610832576100ea565b806361d01967116100c857806361d01967146104285780636c5536b21461046e57806371571603146104dc5780639d684f9b146104fa576100ea565b80631c8590ba146100ef5780634a97db7a146102f657806360894e4314610355575b600080fd5b6101316004803603602081101561010557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061097e565b604051808c81526020018b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018a815260200189815260200188815260200187815260200186815260200180602001806020018560028111156101a357fe5b60ff16815260200184810384528d818151815260200191508051906020019080838360005b838110156101e35780820151818401526020810190506101c8565b50505050905090810190601f1680156102105780820380516001836020036101000a031916815260200191505b50848103835287818151815260200191508051906020019080838360005b8381101561024957808201518184015260208101905061022e565b50505050905090810190601f1680156102765780820380516001836020036101000a031916815260200191505b50848103825286818151815260200191508051906020019080838360005b838110156102af578082015181840152602081019050610294565b50505050905090810190601f1680156102dc5780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390f35b6102fe610bcd565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610341578082015181840152602081019050610326565b505050509050019250505060405180910390f35b61040e6004803603602081101561036b57600080fd5b810190808035906020019064010000000081111561038857600080fd5b82018360208201111561039a57600080fd5b803590602001918460018302840111640100000000831117156103bc57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050610c5b565b604051808215151515815260200191505060405180910390f35b6104546004803603602081101561043e57600080fd5b8101908080359060200190929190505050610d35565b604051808215151515815260200191505060405180910390f35b61049a6004803603602081101561048457600080fd5b8101908080359060200190929190505050610dff565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6104e4610e3b565b6040518082815260200191505060405180910390f35b610717600480360361010081101561051157600080fd5b810190808035906020019064010000000081111561052e57600080fd5b82018360208201111561054057600080fd5b8035906020019184600183028401116401000000008311171561056257600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929080359060200190929190803590602001909291908035906020019092919080359060200190929190803590602001906401000000008111156105ed57600080fd5b8201836020820111156105ff57600080fd5b8035906020019184600183028401116401000000008311171561062157600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561068457600080fd5b82018360208201111561069657600080fd5b803590602001918460018302840111640100000000831117156106b857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803560ff169060200190929190505050610e44565b005b6107d26004803603602081101561072f57600080fd5b810190808035906020019064010000000081111561074c57600080fd5b82018360208201111561075e57600080fd5b8035906020019184600183028401116401000000008311171561078057600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050611276565b604051808215151515815260200191505060405180910390f35b6108186004803603602081101561080257600080fd5b8101908080359060200190929190505050611350565b604051808215151515815260200191505060405180910390f35b61085e6004803603602081101561084857600080fd5b810190808035906020019092919050505061141a565b604051808215151515815260200191505060405180910390f35b6108ba6004803603602081101561088e57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506114e4565b604051808215151515815260200191505060405180910390f35b610900600480360360208110156108ea57600080fd5b8101908080359060200190929190505050611542565b604051808215151515815260200191505060405180910390f35b61092261160c565b6040518082815260200191505060405180910390f35b6109646004803603602081101561094e57600080fd5b8101908080359060200190929190505050611612565b604051808215151515815260200191505060405180910390f35b60016020528060005260406000206000915090508060000154908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a565780601f10610a2b57610100808354040283529160200191610a56565b820191906000526020600020905b815481529060010190602001808311610a3957829003601f168201915b505050505090806003015490806004015490806005015490806006015490806007015490806008018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b125780601f10610ae757610100808354040283529160200191610b12565b820191906000526020600020905b815481529060010190602001808311610af557829003601f168201915b505050505090806009018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bb05780601f10610b8557610100808354040283529160200191610bb0565b820191906000526020600020905b815481529060010190602001808311610b9357829003601f168201915b50505050509080600a0160009054906101000a900460ff1690508b565b60606002805480602002602001604051908101604052809291908181526020018280548015610c5157602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610c07575b5050505050905090565b6000610c66336114e4565b15610d2b576000600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610d295782816008019080519060200190610d1e9291906116dc565b506001915050610d30565b505b600090505b919050565b6000610d40336114e4565b15610df5576000600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610df3578281600501819055506001915050610dfa565b505b600090505b919050565b60028181548110610e0c57fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60008054905090565b6000339050600080815480929190600101919050555060405180610160016040528060005481526020018273ffffffffffffffffffffffffffffffffffffffff1681526020018a815260200189815260200160008152602001888152602001878152602001868152602001858152602001848152602001836002811115610ec757fe5b815250600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000820151816000015560208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506040820151816002019080519060200190610f7692919061175c565b50606082015181600301556080820151816004015560a0820151816005015560c0820151816006015560e08201518160070155610100820151816008019080519060200190610fc692919061175c565b50610120820151816009019080519060200190610fe492919061175c565b5061014082015181600a0160006101000a81548160ff0219169083600281111561100a57fe5b021790555090505060028190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507fef6a5ac038769447cdbee72f2cff6a92d5bc5ac5435c59b5c4d056ae619b8504600054828b8b60008c8c8c8c8c8c604051808c81526020018b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018a8152602001898152602001888152602001878152602001868152602001806020018060200185600281111561111957fe5b60ff16815260200184810384528d818151815260200191508051906020019080838360005b8381101561115957808201518184015260208101905061113e565b50505050905090810190601f1680156111865780820380516001836020036101000a031916815260200191505b50848103835287818151815260200191508051906020019080838360005b838110156111bf5780820151818401526020810190506111a4565b50505050905090810190601f1680156111ec5780820380516001836020036101000a031916815260200191505b50848103825286818151815260200191508051906020019080838360005b8381101561122557808201518184015260208101905061120a565b50505050905090810190601f1680156112525780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390a1505050505050505050565b6000611281336114e4565b15611346576000600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141561134457828160020190805190602001906113399291906116dc565b50600191505061134b565b505b600090505b919050565b600061135b336114e4565b15611410576000600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141561140e578281600701819055506001915050611415565b505b600090505b919050565b6000611425336114e4565b156114da576000600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156114d85782816006018190555060019150506114df565b505b600090505b919050565b600080600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000015414611538576001905061153d565b600090505b919050565b600061154d336114e4565b15611602576000600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415611600578281600401819055506001915050611607565b505b600090505b919050565b60005481565b600061161d336114e4565b156116d2576000600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156116d05782816003018190555060019150506116d7565b505b600090505b919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061171d57805160ff191683800117855561174b565b8280016001018555821561174b579182015b8281111561174a57825182559160200191906001019061172f565b5b50905061175891906117dc565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061179d57805160ff19168380011785556117cb565b828001600101855582156117cb579182015b828111156117ca5782518255916020019190600101906117af565b5b5090506117d891906117dc565b5090565b6117fe91905b808211156117fa5760008160009055506001016117e2565b5090565b9056fea265627a7a72315820b4ee38a4a89627fe27dd3bf185b2b678829330563dbbd16d6b28947b982223fb64736f6c63430005110032";

    public static final String FUNC_GETPEERCOUNT = "getPeerCount";

    public static final String FUNC_GETPUBLICADDRESS = "getPublicAddress";

    public static final String FUNC_ISEXISTS = "isExists";

    public static final String FUNC_PEERCOUNT = "peerCount";

    public static final String FUNC_PEERS = "peers";

    public static final String FUNC_PUBLICADDRESS = "publicAddress";

    public static final String FUNC_REGISTERPEER = "registerPeer";

    public static final String FUNC_UPDATEAVAILABLETIMERANGE = "updateAvailableTimeRange";

    public static final String FUNC_UPDATEMAXBANDWIDTH = "updateMaxBandwidth";

    public static final String FUNC_UPDATEMAXUSER = "updateMaxUser";

    public static final String FUNC_UPDATEPUBLICURL = "updatePublicUrl";

    public static final String FUNC_UPDATETOTALSPACE = "updateTotalSpace";

    public static final String FUNC_UPDATEUPTIMEPERCENTAGE = "updateUpTimePercentage";

    public static final String FUNC_UPDATEUSEDSPACE = "updateUsedSpace";

    public static final Event PEERCREATED_EVENT = new Event("PeerCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}));
    ;

    @Deprecated
    protected PeerList(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PeerList(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PeerList(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PeerList(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<PeerCreatedEventResponse> getPeerCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PEERCREATED_EVENT, transactionReceipt);
        ArrayList<PeerCreatedEventResponse> responses = new ArrayList<PeerCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PeerCreatedEventResponse typedResponse = new PeerCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.owner = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.public_url = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.totalSpace = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.usedSpace = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.maxBandwidth = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.maxUser = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.uptimePercentage = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.availableTimeRange = (String) eventValues.getNonIndexedValues().get(8).getValue();
            typedResponse.date = (String) eventValues.getNonIndexedValues().get(9).getValue();
            typedResponse.status = (BigInteger) eventValues.getNonIndexedValues().get(10).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PeerCreatedEventResponse> peerCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PeerCreatedEventResponse>() {
            @Override
            public PeerCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PEERCREATED_EVENT, log);
                PeerCreatedEventResponse typedResponse = new PeerCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.owner = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.public_url = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.totalSpace = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.usedSpace = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.maxBandwidth = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.maxUser = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.uptimePercentage = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.availableTimeRange = (String) eventValues.getNonIndexedValues().get(8).getValue();
                typedResponse.date = (String) eventValues.getNonIndexedValues().get(9).getValue();
                typedResponse.status = (BigInteger) eventValues.getNonIndexedValues().get(10).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PeerCreatedEventResponse> peerCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PEERCREATED_EVENT));
        return peerCreatedEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> getPeerCount() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPEERCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> getPublicAddress() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPUBLICADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Boolean> isExists(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISEXISTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> peerCount() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PEERCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger>> peers(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PEERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger>>(function,
                new Callable<Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger>>() {
                    @Override
                    public Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue(), 
                                (String) results.get(8).getValue(), 
                                (String) results.get(9).getValue(), 
                                (BigInteger) results.get(10).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> publicAddress(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PUBLICADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> registerPeer(String _url, BigInteger _totalSpace, BigInteger _maxBandwidth, BigInteger _maxUser, BigInteger _uptimePercentage, String _availableTimeRange, String _date, BigInteger _status) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REGISTERPEER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_url), 
                new org.web3j.abi.datatypes.generated.Int256(_totalSpace), 
                new org.web3j.abi.datatypes.generated.Int256(_maxBandwidth), 
                new org.web3j.abi.datatypes.generated.Int256(_maxUser), 
                new org.web3j.abi.datatypes.generated.Int256(_uptimePercentage), 
                new org.web3j.abi.datatypes.Utf8String(_availableTimeRange), 
                new org.web3j.abi.datatypes.Utf8String(_date), 
                new org.web3j.abi.datatypes.generated.Uint8(_status)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateAvailableTimeRange(String _timeRange) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEAVAILABLETIMERANGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_timeRange)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateMaxBandwidth(BigInteger _maxBandwidth) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEMAXBANDWIDTH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_maxBandwidth)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateMaxUser(BigInteger _maxUser) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEMAXUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_maxUser)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updatePublicUrl(String _newUrl) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEPUBLICURL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_newUrl)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateTotalSpace(BigInteger _totalSpace) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATETOTALSPACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_totalSpace)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateUpTimePercentage(BigInteger _uptime) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEUPTIMEPERCENTAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_uptime)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateUsedSpace(BigInteger _usedSpace) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEUSEDSPACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_usedSpace)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static PeerList load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PeerList(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PeerList load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PeerList(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PeerList load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PeerList(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PeerList load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PeerList(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PeerList> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PeerList.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PeerList> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PeerList.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<PeerList> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PeerList.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PeerList> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PeerList.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class PeerCreatedEventResponse extends BaseEventResponse {
        public BigInteger id;

        public String owner;

        public String public_url;

        public BigInteger totalSpace;

        public BigInteger usedSpace;

        public BigInteger maxBandwidth;

        public BigInteger maxUser;

        public BigInteger uptimePercentage;

        public String availableTimeRange;

        public String date;

        public BigInteger status;
    }
}
