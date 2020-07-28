package contract;

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
import org.web3j.abi.datatypes.Bool;
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
import org.web3j.tuples.generated.Tuple10;
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
    private static final String BINARY = "60806040526000805534801561001457600080fd5b50610cb1806100246000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c8063011eeab61461005c5780639d36788e1461011b578063be4f3e8f14610138578063e155f32314610337578063e81ea5951461058a575b600080fd5b6101076004803603604081101561007257600080fd5b81359190810190604081016020820135600160201b81111561009357600080fd5b8201836020820111156100a557600080fd5b803590602001918460018302840111600160201b831117156100c657600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506105a4945050505050565b604080519115158252519081900360200190f35b6101076004803603602081101561013157600080fd5b50356105ee565b6101556004803603602081101561014e57600080fd5b5035610613565b604051808b8152602001806020018a815260200189815260200188815260200187815260200180602001806020018060200186600281111561019357fe5b60ff16815260200185810385528e818151815260200191508051906020019080838360005b838110156101d05781810151838201526020016101b8565b50505050905090810190601f1680156101fd5780820380516001836020036101000a031916815260200191505b5085810384528951815289516020918201918b019080838360005b83811015610230578181015183820152602001610218565b50505050905090810190601f16801561025d5780820380516001836020036101000a031916815260200191505b5085810383528851815288516020918201918a019080838360005b83811015610290578181015183820152602001610278565b50505050905090810190601f1680156102bd5780820380516001836020036101000a031916815260200191505b50858103825287518152875160209182019189019080838360005b838110156102f05781810151838201526020016102d8565b50505050905090810190601f16801561031d5780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390f35b610588600480360361012081101561034e57600080fd5b810190602081018135600160201b81111561036857600080fd5b82018360208201111561037a57600080fd5b803590602001918460018302840111600160201b8311171561039b57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929584359560208601359560408101359550606081013594509192509060a081019060800135600160201b81111561040557600080fd5b82018360208201111561041757600080fd5b803590602001918460018302840111600160201b8311171561043857600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561048a57600080fd5b82018360208201111561049c57600080fd5b803590602001918460018302840111600160201b831117156104bd57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561050f57600080fd5b82018360208201111561052157600080fd5b803590602001918460018302840111600160201b8311171561054257600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505050903560ff16915061088e9050565b005b610592610bdb565b60408051918252519081900360200190f35b60006105af836105ee565b156105e4576000838152600160208181526040909220845190926105d99284019190860190610be1565b5060019150506105e8565b5060005b92915050565b6000818152600160205260408120541561060a5750600161060e565b5060005b919050565b600160208181526000928352604092839020805481840180548651600296821615610100026000190190911695909504601f810185900485028601850190965285855290949193929091908301828280156106af5780601f10610684576101008083540402835291602001916106af565b820191906000526020600020905b81548152906001019060200180831161069257829003601f168201915b505050600280850154600386015460048701546005880154600689018054604080516020601f6000196101006001871615020190941699909904928301899004890281018901909152818152999a9599949850929650909490919083018282801561075b5780601f106107305761010080835404028352916020019161075b565b820191906000526020600020905b81548152906001019060200180831161073e57829003601f168201915b5050505060078301805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529495949350908301828280156107eb5780601f106107c0576101008083540402835291602001916107eb565b820191906000526020600020905b8154815290600101906020018083116107ce57829003601f168201915b5050505060088301805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815294959493509083018282801561087b5780601f106108505761010080835404028352916020019161087b565b820191906000526020600020905b81548152906001019060200180831161085e57829003601f168201915b5050506009909301549192505060ff168a565b600080815480929190600101919050555060405180610140016040528060005481526020018a81526020018981526020018881526020018781526020018681526020018581526020018481526020018381526020018260028111156108ef57fe5b905260008054815260016020818152604090922083518155838301518051919361091e93850192910190610be1565b5060408201516002820155606082015160038201556080820151600482015560a0820151600582015560c08201518051610962916006840191602090910190610be1565b5060e0820151805161097e916007840191602090910190610be1565b50610100820151805161099b916008840191602090910190610be1565b5061012082015160098201805460ff191660018360028111156109ba57fe5b02179055509050507f82d01641317b3c20b20355dc49be17731907a27c66374c518781baa983cea47c6000548a8a8a8a8a8a8a8a8a604051808b8152602001806020018a8152602001898152602001888152602001878152602001806020018060200180602001866002811115610a2d57fe5b60ff16815260200185810385528e818151815260200191508051906020019080838360005b83811015610a6a578181015183820152602001610a52565b50505050905090810190601f168015610a975780820380516001836020036101000a031916815260200191505b5085810384528951815289516020918201918b019080838360005b83811015610aca578181015183820152602001610ab2565b50505050905090810190601f168015610af75780820380516001836020036101000a031916815260200191505b5085810383528851815288516020918201918a019080838360005b83811015610b2a578181015183820152602001610b12565b50505050905090810190601f168015610b575780820380516001836020036101000a031916815260200191505b50858103825287518152875160209182019189019080838360005b83811015610b8a578181015183820152602001610b72565b50505050905090810190601f168015610bb75780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390a1505050505050505050565b60005481565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610c2257805160ff1916838001178555610c4f565b82800160010185558215610c4f579182015b82811115610c4f578251825591602001919060010190610c34565b50610c5b929150610c5f565b5090565b610c7991905b80821115610c5b5760008155600101610c65565b9056fea265627a7a72315820e903d98670585a68e0aec1bb05b9be6f176ea8c2264ea4c02820e5f819ceb74764736f6c634300050c0032";

    public static final String FUNC_ISEXISTS = "isExists";

    public static final String FUNC_PEERCOUNT = "peerCount";

    public static final String FUNC_PEERS = "peers";

    public static final String FUNC_REGISTERPEER = "registerPeer";

    public static final String FUNC_UPDATEPUBLICADDRESS = "updatePublicAddress";

    public static final Event PEERCREATED_EVENT = new Event("PeerCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}));
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
            typedResponse.public_address = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.totalSpace = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.maxBandwidth = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.maxUser = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.uptimePercentage = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.availableTimeRange = (String) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.description = (String) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.date = (String) eventValues.getNonIndexedValues().get(8).getValue();
            typedResponse.status = (BigInteger) eventValues.getNonIndexedValues().get(9).getValue();
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
                typedResponse.public_address = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.totalSpace = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.maxBandwidth = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.maxUser = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.uptimePercentage = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.availableTimeRange = (String) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.description = (String) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.date = (String) eventValues.getNonIndexedValues().get(8).getValue();
                typedResponse.status = (BigInteger) eventValues.getNonIndexedValues().get(9).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PeerCreatedEventResponse> peerCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PEERCREATED_EVENT));
        return peerCreatedEventFlowable(filter);
    }

    public RemoteFunctionCall<Boolean> isExists(BigInteger _index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISEXISTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> peerCount() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PEERCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple10<BigInteger, String, BigInteger, BigInteger, BigInteger, BigInteger, String, String, String, BigInteger>> peers(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PEERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple10<BigInteger, String, BigInteger, BigInteger, BigInteger, BigInteger, String, String, String, BigInteger>>(function,
                new Callable<Tuple10<BigInteger, String, BigInteger, BigInteger, BigInteger, BigInteger, String, String, String, BigInteger>>() {
                    @Override
                    public Tuple10<BigInteger, String, BigInteger, BigInteger, BigInteger, BigInteger, String, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple10<BigInteger, String, BigInteger, BigInteger, BigInteger, BigInteger, String, String, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (String) results.get(7).getValue(), 
                                (String) results.get(8).getValue(), 
                                (BigInteger) results.get(9).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> registerPeer(String _address, BigInteger _totalSpace, BigInteger _maxBandwidth, BigInteger _maxUser, BigInteger _uptimePercentage, String _availableTimeRange, String _description, String _date, BigInteger _status) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REGISTERPEER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_address), 
                new org.web3j.abi.datatypes.generated.Int256(_totalSpace), 
                new org.web3j.abi.datatypes.generated.Int256(_maxBandwidth), 
                new org.web3j.abi.datatypes.generated.Int256(_maxUser), 
                new org.web3j.abi.datatypes.generated.Int256(_uptimePercentage), 
                new org.web3j.abi.datatypes.Utf8String(_availableTimeRange), 
                new org.web3j.abi.datatypes.Utf8String(_description), 
                new org.web3j.abi.datatypes.Utf8String(_date), 
                new org.web3j.abi.datatypes.generated.Uint8(_status)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updatePublicAddress(BigInteger _index, String _newAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEPUBLICADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index), 
                new org.web3j.abi.datatypes.Utf8String(_newAddress)), 
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

        public String public_address;

        public BigInteger totalSpace;

        public BigInteger maxBandwidth;

        public BigInteger maxUser;

        public BigInteger uptimePercentage;

        public String availableTimeRange;

        public String description;

        public String date;

        public BigInteger status;
    }
}
