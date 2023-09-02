package ca.zaher88abd.krosbridge.services.std

import ca.zaher88abd.krosbridge.services.ServiceRequest
import ca.zaher88abd.krosbridge.services.ServiceResponse
import org.json.JSONObject


/**
 * The std_srvs/Empty service.
 *
 * @author Zaher Abd Ulmoula -- zaher88abd@gmail.com
 * @version Sep 2, 2023
 */
class Empty {
    /**
     * The service type.
     */
    companion object {
        val TYPE: String = "std_srvs/Empty"
    }

    /**
     * The service request for the Empty service.
     *
     * @author Zaher Abd Ulmoula -- zaher88abd@gmail.com
     * @version Sep 2, 2023
     */
    class Request : ServiceRequest(
        jsonString = EMPTY_MESSAGE,
        serviceRequestType = TYPE
    ) {
        /**
         * Create a clone of this Empty ServiceRequest.
         */
        override fun clone(): Request {
            return Request()
        }

        /**
         * Create a new Empty ServiceRequest based on the given JSON string. Any
         * missing values will be set to their defaults.
         *
         * @param jsonString
         * The JSON string to parse.
         * @return A Empty ServiceRequest based on the given JSON string.
         */
        fun fromJsonString(jsonString: String): Request {
            // convert to a ServiceRequest
            return fromServiceRequest(
                ServiceRequest(
                    jsonString = this.toString()
                )
            )
        }

        /**
         * Create a new Empty ServiceRequest based on the given ServiceRequest.
         * Any missing values will be set to their defaults.
         *
         * @param m
         * The ServiceRequest to parse.
         * @return A Empty ServiceRequest based on the given Message.
         */
        fun fromServiceRequest(req: ServiceRequest): Request {
            // get it from the JSON object
            return fromJsonObject(req.toJsonObject())
        }

        /**
         * Create a new Empty ServiceRequest based on the given JSON object. Any
         * missing values will be set to their defaults.
         *
         * @param jsonObject
         * The JSON object to parse.
         * @return A Empty ServiceRequest based on the given JSON object.
         */
        fun fromJsonObject(jsonObject: JSONObject): Request {
            return Request()
        }
    }

    /**
     * The service response for the Empty service.
     *
     * @author Zaher Abd Ulmoula -- zaher88abd@gmail.com
     * @version Sep 2, 2023
     */
    class Response : ServiceResponse(
        jsonString = ServiceRequest.EMPTY_MESSAGE,
        serviceResponseType = TYPE
    ) {
        /**
         * Create a clone of this Empty ServiceRequest.
         */
        override fun clone(): Response {
            return Response()
        }

        /**
         * Create a new Empty ServiceRequest based on the given JSON string. Any
         * missing values will be set to their defaults.
         *
         * @param jsonString
         * The JSON string to parse.
         * @return A Empty ServiceRequest based on the given JSON string.
         */
        fun fromJsonString(jsonString: String): Response {
            // convert to a ServiceRequest
            return fromServiceResponse(
                ServiceResponse(
                    jsonString = this.toString()
                )
            )
        }

        /**
         * Create a new Empty ServiceRequest based on the given ServiceRequest.
         * Any missing values will be set to their defaults.
         *
         * @param m
         * The ServiceRequest to parse.
         * @return A Empty ServiceRequest based on the given Message.
         */
        fun fromServiceResponse(req: ServiceResponse): Response {
            // get it from the JSON object
            return fromJsonObject(req.toJsonObject())
        }

        /**
         * Create a new Empty ServiceRequest based on the given JSON object. Any
         * missing values will be set to their defaults.
         *
         * @param jsonObject
         * The JSON object to parse.
         * @return A Empty ServiceRequest based on the given JSON object.
         */
        fun fromJsonObject(jsonObject: JSONObject): Response {
            return Response()
        }
    }
}