package org.folio.rest.impl;

import java.util.Map;

import javax.ws.rs.core.Response;

import org.folio.rest.jaxrs.model.VendorCode;
import org.folio.rest.jaxrs.model.VendorCodeCollection;
import org.folio.rest.jaxrs.resource.OrdersStorageVendorCodes;
import org.folio.rest.persist.PgUtil;

import io.vertx.core.AsyncResult;
import io.vertx.core.Context;
import io.vertx.core.Handler;

public class VendorCodesAPI implements OrdersStorageVendorCodes {

  public static final String VC_TABLE = "vendor_code";

  @Override
  public void getOrdersStorageVendorCodes(String query, int offset, int limit, String lang, Map<String, String> okapiHeaders,
      Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) {
    PgUtil.get(VC_TABLE, VendorCode.class, VendorCodeCollection.class, query, offset, limit, okapiHeaders, vertxContext,
        OrdersStorageVendorCodes.GetOrdersStorageVendorCodesResponse.class, asyncResultHandler);
  }

  @Override
  public void postOrdersStorageVendorCodes(String lang, VendorCode entity, Map<String, String> okapiHeaders,
      Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) {
    PgUtil.post(VC_TABLE, entity, okapiHeaders, vertxContext, OrdersStorageVendorCodes.PostOrdersStorageVendorCodesResponse.class,
        asyncResultHandler);
  }

  @Override
  public void getOrdersStorageVendorCodesById(String id, String lang, Map<String, String> okapiHeaders,
      Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) {
    PgUtil.getById(VC_TABLE, VendorCode.class, id, okapiHeaders, vertxContext,
        OrdersStorageVendorCodes.DeleteOrdersStorageVendorCodesByIdResponse.class, asyncResultHandler);
  }

  @Override
  public void deleteOrdersStorageVendorCodesById(String id, String lang, Map<String, String> okapiHeaders,
      Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) {
    PgUtil.deleteById(VC_TABLE, id, okapiHeaders, vertxContext,
        OrdersStorageVendorCodes.DeleteOrdersStorageVendorCodesByIdResponse.class, asyncResultHandler);
  }

  @Override
  public void putOrdersStorageVendorCodesById(String id, String lang, VendorCode entity, Map<String, String> okapiHeaders,
      Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) {
    PgUtil.put(VC_TABLE, entity, id, okapiHeaders, vertxContext,
        OrdersStorageVendorCodes.PutOrdersStorageVendorCodesByIdResponse.class, asyncResultHandler);
  }
}
