package besu;

import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Decoder {

    public static void main(String[] args) {
        decodeSingleValue();
        decodeMultipleValue();
    }

    private static void decodeSingleValue() {
        String data = "0x000000000000000000000000000000000000000000000000000000000000005";
        String functionName = "getData"; 
        Function function = new Function(
                functionName,
                Collections.<Type>emptyList(),
                Arrays.asList(new TypeReference<Uint>() {}));
        List<Type> decodedResult = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        System.out.println("Decode: " + decodedResult.get(0).getValue());

    }

    private static void decodeMultipleValue() {
        String data = "0x000000000000000000000000000000000000000000000000000000000000005"+"0000000000000000000000000000000000000000000000000000000000000009"+"0000000000000000000000000000000000000000000000000000000000000004";
        String functionName = "getData"; 
        Function function = new Function(
                functionName,
                Collections.<Type>emptyList(),
                Arrays.asList(new TypeReference<Uint>() {}, new TypeReference<Uint>() {}, new TypeReference<Uint>() {}));
        List<Type> decodedResult = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        for (Type type : decodedResult) {
            System.out.println("Decoded Value: " + type.getValue());
        }

    }

    

    // public static List<Type> decode() {
    //     String data = "0x000000000000000000000000000000000000000000000000000000000000005"+
    //     "0000000000000000000000000000000000000000000000000000000000000002";
    //     String functionName = "getData"; 
    //     // BigInteger a = BigInteger.valueOf(1);
    //     Function function = new Function(
    //             functionName,
    //             Collections.<Type>emptyList(),
    //             Arrays.asList(new TypeReference<Uint>() {}, new TypeReference<Uint>() {}));
        
    //     return FunctionReturnDecoder.decode(data, function.getOutputParameters());
    // }
    
    // public static void main(String[] args) {
    //     // System.out.println(returnData);
    //     List<Type> decodedResult = decode();
    //     // for (Type type : decodedResult) {
    //     System.out.println(decodedResult.get(0).getValue());
    //     System.out.println(decodedResult.get(1).getValue());
    //     System.out.println(decodedResult.size());
       
    // }
    
}
