package gunmarket.web;

import gunmarket.model.Product;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductRefreshApi {

    @ApiOperation(value = "!!!",
            notes = "!!!",
            response = ResponseEntity.class)
    ResponseEntity<List<Product>> refreshProducts();

}
