package ca.zaher88abd.krosbridge.services

import ca.zaher88abd.krosbridge.JsonWrapper
import org.json.JSONObject

open class ServiceResponse : JsonWrapper {

    private var serviceResponseType: String
    private var result: Boolean

    constructor(
        jsonObject: JSONObject? = null,
        jsonString: String? = null,
        serviceResponseType: String = "",
        result: Boolean = true
    ) : super(jsonObject, jsonString) {
        this.serviceResponseType = serviceResponseType
        this.result = result
    }

    /**
     * The String representation of an empty service response in JSON.
     */
    companion object {
        val EMPTY_MESSAGE: String = JsonWrapper.EMPTY_JSON
    }

    /**
     * Get the type of the service response if one was set.
     *
     * @return The type of the service response.
     */
    fun getServiceResponseType(): String? {
        return serviceResponseType
    }

    /**
     * Get the result flag of this response (i.e., if the service server
     * returned a success).
     *
     * @return The result flag for the response.
     */
    fun getResult(): Boolean {
        return result
    }

    /**
     * Set the type of the service response.
     *
     * @param serviceResponseType
     * The type of the service response (e.g., "std_srvs/Empty").
     */
    fun setServiceResponseType(serviceResponseType: String?) {
        this.serviceResponseType = serviceResponseType!!
    }


    override fun clone(): JsonWrapper {
        return ServiceResponse(
            this.toJsonObject(),
            serviceResponseType = this.serviceResponseType,
            result = this.result
        )
    }
}