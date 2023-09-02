package ca.zaher88abd.krosbridge.services

import ca.zaher88abd.krosbridge.JsonWrapper
import org.json.JSONObject


open class ServiceRequest : JsonWrapper {
    private var serviceRequestType: String
    private var id: String

    constructor(
        jsonObject: JSONObject? = null,
        jsonString: String? = null,
        serviceRequestType: String = ""
    ) : super(jsonObject, jsonString) {
        this.serviceRequestType = serviceRequestType
        this.id = ""
    }

    companion object {
        /**
         * The String representation of an empty service request in JSON.
         */
        val EMPTY_MESSAGE: String = JsonWrapper.EMPTY_JSON
    }

    /**
     * Get the type of the service request if one was set.
     *
     * @return The type of the service request.
     */
    fun getServiceRequestType(): String {
        return serviceRequestType
    }

    /**
     * Set the type of the service request.
     *
     * @param serviceRequestType
     * The type of the service request (e.g., "std_srvs/Empty").
     */
    fun setServiceRequestType(serviceRequestType: String) {
        this.serviceRequestType = serviceRequestType
    }

    /**
     * Set the ID of the service request.
     *
     * @param id
     * The new ID.
     */
    fun setId(id: String) {
        this.id = id
    }

    /**
     * Get the ID of the service request.
     *
     * @return The ID.
     */
    fun getId(): String {
        return id
    }

    /**
     * Create a clone of this ServiceRequest.
     */
    override fun clone(): JsonWrapper {
        return ServiceRequest(
            this.toJsonObject(),
            serviceRequestType = this.getServiceRequestType()
        )
    }

}