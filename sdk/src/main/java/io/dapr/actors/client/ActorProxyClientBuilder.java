/*
 * Copyright (c) Microsoft Corporation.
 * Licensed under the MIT License.
 */

package io.dapr.actors.client;

import okhttp3.OkHttpClient;
import io.dapr.actors.*;

/**
 * Builds an instance of ActorProxyAsyncClient.
 */
class ActorProxyClientBuilder extends AbstractClientBuilder {

    /**
     * Default port for Dapr after checking environment variable.
     */
    private int port = ActorProxyClientBuilder.GetEnvPortOrDefault();

    /**
     * Builds an async client.
     * @return Builds an async client.
     */
    public ActorProxyAsyncClient buildAsyncClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // TODO: Expose configurations for OkHttpClient or com.microsoft.rest.RestClient.
        return new ActorProxyHttpAsyncClient(this.port, builder.build());
    }
}