package ca.zaher88abd.krosbridge

import org.json.JSONObject


/**
 * JsonWrapper objects are used as a wrapper around JSON objects. That is, they
 * are a reusable convince for messages and services. This objects are immutable
 * and declared abstract as they should not be used directly.
 *
 * @author Zaher Abd Ulmoula - zaher88abd@gmail.com
 * @version Sep 1, 2023
 */

abstract class JsonWrapper {


    private lateinit var jsonObject: JSONObject
    private lateinit var jsonString: String

    /**
     * Create a Message based on the given JSON object.
     *
     * @param jsonObject
     * The JSON object containing the message data.
     */
    constructor(jsonObject: JSONObject? = null, jsonString: String? = null) {
        if (jsonString == null) {
            this.jsonString = EMPTY_JSON
        }
        if (jsonObject == null) {
            this.jsonObject = JSONObject(this.jsonString)
        }
    }

    /**
     * Get the JSON object.
     *
     * @return The JSON object.
     */
    open fun toJsonObject(): JSONObject {
        return jsonObject
    }

    /**
     * Get the String representation of this JSON object in JSON format.
     *
     * @return The String representation of this JSON object in JSON format.
     */
    override fun toString(): String {
        return this.jsonString
    }

    /**
     * Create a clone of this JSON object.
     */
    abstract fun clone(): JsonWrapper?

    /**
     * Return the hash code of this JSON object, which is the hash code of the
     * JSON string.
     *
     * @return The hash code of the message.
     */
    override fun hashCode(): Int {
        return jsonString.hashCode()
    }

    /**
     * Test if the given Object is equal to this JsonWrapper. Two JsonWrappers
     * are equal if and only if their JSON strings match.
     *
     * @param o
     * The Object to test equality with.
     * @return If the given Object is equal to this JsonWrapper.
     */
    open fun equals(o: Any): Boolean {
        return o === this || o is JsonWrapper && jsonString == o
            .toString()
    }

    /**
     * The String representation of an empty message in JSON.
     */
    companion object {
        val EMPTY_JSON: String = "{}"
    }
}