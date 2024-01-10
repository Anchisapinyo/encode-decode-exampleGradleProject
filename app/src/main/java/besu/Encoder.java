package besu;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.Type;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Encoder {

    public static void main(String[] args) {
        encodeFunction();
        encodeParameters();
    }

    private static void encodeFunction() {
        Function function = new Function(
                "abc",
                Arrays.asList(new Uint256(BigInteger.valueOf(1)), new Address("0x1234567890123456789012345678901234567890")),
                Collections.emptyList()
        );

        String encodedFunction = FunctionEncoder.encode(function);
        System.out.println("Encoded function: " + encodedFunction);
    }

    private static void encodeParameters() {
        List<Type> parameters = Arrays.asList(new Uint256(BigInteger.valueOf(1)), new Address("0x1234567890123456789012345678901234567890"));
        String encodedConstructor = FunctionEncoder.encodeConstructor(parameters);
        System.out.println("Encoded constructor: " + encodedConstructor);
    }

}
