package com.proofpoint.api;

import com.proofpoint.dto.request.NewsRequest;
import com.proofpoint.dto.response.NewsResponse;
import com.proofpoint.dto.response.PendingNewsResponse;
import com.proofpoint.enums.DocumentTypeCategory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/news")
@Tag(name = "News", description = "Create news in blockchain system")
public interface NewsAPI {

    @PostMapping
    @Operation(operationId = "Save", summary = "Save New News")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = PendingNewsResponse.class)))})
    public PendingNewsResponse createNews(@RequestBody NewsRequest request);

    @GetMapping("/{id}")
    @Operation(operationId = "Get", summary = "Get News By Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = NewsResponse.class)))})
    public NewsResponse getNews(@PathVariable("id") String id);

    @GetMapping("/tx/{txId}")
    @Operation(operationId = "Get", summary = "Get News By Transaction Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = NewsResponse.class)))})
    public NewsResponse getNewsByTxId(@PathVariable("txId") String txId);

    @GetMapping
    @Operation(operationId = "Get", summary = "Get News")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = NewsResponse[].class)))})
    public List<NewsResponse> getNews();

    @GetMapping("/category/{category}")
    @Operation(operationId = "Get", summary = "Get News By Transaction Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = NewsResponse[].class)))})
    public List<NewsResponse> getNewsByCategory(@PathVariable("category") DocumentTypeCategory category);

    @GetMapping("/approve-pending")
    @Operation(operationId = "Get", summary = "Get News By Status Pending")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = PendingNewsResponse[].class)))})
    public List<PendingNewsResponse> getNewsWhichWaitingForApprove();

    @PutMapping("/approve-pending")
    @Operation(operationId = "Put", summary = "Approve News")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = NewsResponse[].class)))})
    public List<NewsResponse> approveNews(@RequestBody List<String> newsIds);
}
