package com.proofpoint.controller;

import com.proofpoint.api.NewsAPI;
import com.proofpoint.dto.request.NewsRequest;
import com.proofpoint.dto.response.NewsResponse;
import com.proofpoint.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NewsController implements NewsAPI {

    private final NewsService newsService;

    @Override
    public NewsResponse createNews(NewsRequest request) {
        return newsService.createNews(request);
    }

    @Override
    public NewsResponse getNews(String id) {
        return newsService.getNews(id);
    }

    @Override
    public NewsResponse getNewsByTxId(String txId) {
        return newsService.getNewsByTxId(txId);
    }

    @Override
    public List<NewsResponse> getNews() {
        return newsService.getNews();
    }
}
