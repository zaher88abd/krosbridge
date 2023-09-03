package ca.zaher88abd.krosbridge.primitives

import ca.zaher88abd.krosbridge.JsonWrapper
import org.json.JSONObject
import java.math.BigInteger


/**
 * Primitive objects are used as a wrapper for non-native ROS primitives. These
 * primitives act as wrappers around JSON objects.
 *
 * This class also contains static functions for dealing with ROS' unsigned
 * numbers.
 *
 * @author Zaher Abd Ulmoula - zaher88abd@gmail.com
 * @version Sep 2, 2023
 */
abstract class Primitive : JsonWrapper {
    /**
     * The String representation of an empty primitive in JSON.
     */
    companion object {
        val EMPTY_MESSAGE: String = JsonWrapper.EMPTY_JSON

        /**
         * Convert the given value to an unsigned 8-bit unsigned integer. This
         * ignores the high 8-bits of the short.
         *
         * @param value
         * The value to convert.
         * @return The value encoded as an 8-bit unsigned integer.
         */
        fun toUInt8(value: Short): Byte {
            // zero out the high 8-bits
            val tmp = (value.toInt() shr 8 shl 8).toShort()
            return (value - tmp).toByte()
        }

        /**
         * Convert the given values to unsigned 8-bit unsigned integers. This
         * ignores the high 8-bits of the input.
         *
         * @param values
         * The values to convert.
         * @return The values encoded as an 8-bit unsigned integer.
         */
        fun toUInt8(values: ShortArray): ByteArray? {
            val tmp = ByteArray(values.size)
            for (i in tmp.indices) {
                tmp[i] = toUInt8(values[i])
            }
            return tmp
        }

        /**
         * Convert the given value in unsigned 8-bit representation into its actual
         * value. That is, all return values of this function will be positive.
         *
         * @param value
         * The unsigned 8-bit value to convert.
         * @return The value of the given 8-bit unsigned value.
         */
        fun fromUInt8(value: Byte): Short {
            return (value.toInt() and 0xFF.toShort().toInt()).toShort()
        }

        /**
         * Convert the given values in unsigned 8-bit representation into their
         * actual values. That is, all return values of this function will be
         * positive.
         *
         * @param values
         * The unsigned 8-bit values to convert.
         * @return The values of the given 8-bit unsigned values.
         */
        fun fromUInt8(values: ByteArray): ShortArray? {
            val tmp = ShortArray(values.size)
            for (i in tmp.indices) {
                tmp[i] = fromUInt8(values[i])
            }
            return tmp
        }

        /**
         * Convert the given value to an unsigned 16-bit unsigned integer. This
         * ignores the high 16-bits of the input.
         *
         * @param value
         * The value to convert.
         * @return The value encoded as an 16-bit unsigned integer.
         */
        fun toUInt16(value: Int): Short {
            // zero out the high 16-bits
            return (value - (value shr 16 shl 16)).toShort()
        }

        /**
         * Convert the given values to unsigned 16-bit unsigned integers. This
         * ignores the high 16-bits of the input.
         *
         * @param values
         * The values to convert.
         * @return The values encoded as an 16-bit unsigned integer.
         */
        fun toUInt16(values: IntArray): ShortArray? {
            val tmp = ShortArray(values.size)
            for (i in tmp.indices) {
                tmp[i] = toUInt16(values[i])
            }
            return tmp
        }

        /**
         * Convert the given value in unsigned 16-bit representation into its actual
         * value. That is, all return values of this function will be positive.
         *
         * @param value
         * The unsigned 16-bit value to convert.
         * @return The value of the given 16-bit unsigned value.
         */
        fun fromUInt16(value: Short): Int {
            return (value.toInt() and 0xFFFF)
        }

        /**
         * Convert the given values in unsigned 16-bit representation into their
         * actual values. That is, all return values of this function will be
         * positive.
         *
         * @param values
         * The unsigned 16-bit values to convert.
         * @return The values of the given 16-bit unsigned values.
         */
        fun fromUInt16(values: ShortArray): IntArray? {
            val tmp = IntArray(values.size)
            for (i in tmp.indices) {
                tmp[i] = fromUInt16(values[i])
            }
            return tmp
        }

        /**
         * Convert the given value to an unsigned 32-bit unsigned integer. This
         * ignores the high 32-bits of the input.
         *
         * @param value
         * The value to convert.
         * @return The value encoded as an 32-bit unsigned integer.
         */
        fun toUInt32(value: Long): Int {
            // zero out the high 32-bits
            return (value - (value shr 32 shl 32)).toInt()
        }

        /**
         * Convert the given values to unsigned 32-bit unsigned integers. This
         * ignores the high 32-bits of the input.
         *
         * @param values
         * The values to convert.
         * @return The values encoded as an 32-bit unsigned integer.
         */
        fun toUInt32(values: LongArray): IntArray? {
            val tmp = IntArray(values.size)
            for (i in tmp.indices) {
                tmp[i] = toUInt32(values[i])
            }
            return tmp
        }

        /**
         * Convert the given value in unsigned 32-bit representation into its actual
         * value. That is, all return values of this function will be positive.
         *
         * @param value
         * The unsigned 32-bit value to convert.
         * @return The value of the given 32-bit unsigned value.
         */
        fun fromUInt32(value: Int): Long {
            return (value.toLong() and 0xFFFFFFFFL)
        }

        /**
         * Convert the given values in unsigned 32-bit representation into their
         * actual values. That is, all return values of this function will be
         * positive.
         *
         * @param values
         * The unsigned 32-bit values to convert.
         * @return The values of the given 64-bit unsigned values.
         */
        fun fromUInt32(values: IntArray): LongArray? {
            val tmp = LongArray(values.size)
            for (i in tmp.indices) {
                tmp[i] = fromUInt32(values[i])
            }
            return tmp
        }

        /**
         * Convert the given value to an unsigned 64-bit unsigned integer. This
         * ignores the high 64-bits of the input.
         *
         * @param value
         * The value to convert.
         * @return The value encoded as an 64-bit unsigned integer.
         */
        fun toUInt64(value: BigInteger): Long {
            return value.toLong()
        }

        /**
         * Convert the given values to unsigned 64-bit unsigned integers. This
         * ignores the high 64-bits of the input.
         *
         * @param values
         * The values to convert.
         * @return The values encoded as an 64-bit unsigned integer.
         */
        fun toUInt64(values: Array<BigInteger>): LongArray? {
            val tmp = LongArray(values.size)
            for (i in tmp.indices) {
                tmp[i] = toUInt64(values[i])
            }
            return tmp
        }

        /**
         * Convert the given value in unsigned 64-bit representation into its actual
         * value. That is, all return values of this function will be positive.
         *
         * @param value
         * The unsigned 64-bit value to convert.
         * @return The value of the given 64-bit unsigned value.
         */
        fun fromUInt64(value: Long): BigInteger? {
            return BigInteger.valueOf(value).and(
                BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE)
            )
        }

        /**
         * Convert the given values in unsigned 64-bit representation into their
         * actual values. That is, all return values of this function will be
         * positive.
         *
         * @param values
         * The unsigned 64-bit values to convert.
         * @return The values of the given 64-bit unsigned values.
         */
        fun fromUInt64(values: LongArray): Array<BigInteger?>? {
            val tmp = arrayOfNulls<BigInteger>(values.size)
            for (i in tmp.indices) {
                tmp[i] = fromUInt64(values[i])
            }
            return tmp
        }
    }

    private var primitiveType: String

    /**
     * Create a Primitive based on the given String representation of a JSON
     * object.
     *
     * @param jsonObject
     *            The JSON object containing the primitive data.
     * @param jsonString
     *            The JSON String to parse.
     * @param primitiveType
     *            The type of the primitive (e.g., "geometry_msgs/Twist").
     */
    constructor(
        jsonObject: JSONObject?, jsonString: String?, primitiveType: String
    ) : super(jsonObject = jsonObject, jsonString = jsonString) {
        this.primitiveType = primitiveType
    }

    /**
     * Get the type of the primitive.
     *
     * @return The type of the primitive.
     */
    open fun getPrimitiveType(): String? {
        return primitiveType
    }

    /**
     * Set the type of the primitive.
     *
     * @param primitiveType
     * The type of the primitive (e.g., "time").
     */
    open fun setPrimitiveType(primitiveType: String?) {
        this.primitiveType = primitiveType!!
    }


}