package com.chadzhou.pinboardJob.rest;

import com.chadzhou.pinboardJob.converter.PinboardEntityToPinboardResponseConverter;
import com.chadzhou.pinboardJob.entity.ArticleEntity;
import com.chadzhou.pinboardJob.entity.PinboardEntity;
import com.chadzhou.pinboardJob.model.request.ArticleRequest;
import com.chadzhou.pinboardJob.model.request.PinRequest;
import com.chadzhou.pinboardJob.model.response.ArticleResponse;
import com.chadzhou.pinboardJob.model.response.PinboardResponse;
import com.chadzhou.pinboardJob.repository.ArticleRepository;
import com.chadzhou.pinboardJob.repository.PageablePinboardRepository;
import com.chadzhou.pinboardJob.repository.PinboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(ResourceConstants.PINBOARDS)
public class PinboardResources {

    @Autowired
    PageablePinboardRepository pageablePinboardRepository;

    @Autowired
    PinboardRepository pinboardRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ConversionService conversionService;

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<PinboardResponse> getAllPinboards(
             Pageable pageable) {
        Page <PinboardEntity> pinboardEntityList = pageablePinboardRepository.findAll(pageable);
        return pinboardEntityList.map(new PinboardEntityToPinboardResponseConverter());
    }

    @RequestMapping(path = "/{pinboardId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PinboardEntity> getPinboardById(
            @PathVariable
            Integer pinboardId) {

        PinboardEntity pinboardEntity = pinboardRepository.findById(pinboardId);
            return new ResponseEntity<>(pinboardEntity, HttpStatus.OK);
    }



    @RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PinboardResponse> postPin(
            @RequestBody
                    PinRequest pinRequest){


        return new ResponseEntity<>(new PinboardResponse(), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{pinboardId}/{articleId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ArticleResponse> putArticle(
            @RequestBody
                    ArticleRequest articleRequest){


        ArticleEntity articleEntity = conversionService.convert(articleRequest, ArticleEntity.class);
        articleRepository.save(articleEntity);
        pinboardRepository.findById(articleRequest.getId());
        ArticleResponse articleResponse = conversionService.convert(articleEntity, ArticleResponse.class);

        return new ResponseEntity<>(articleResponse, HttpStatus.CREATED);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
            public ResponseEntity<PinboardResponse> putPin(
            @RequestBody
                    PinRequest pinRequest){
        return new ResponseEntity<>(new PinboardResponse(), HttpStatus.OK);
    }

    @RequestMapping(path = ResourceConstants.PINBOARDS + "/{pinId}/", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePinboard(
            @PathVariable
                    long pinboardId){
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = ResourceConstants.PINBOARDS + "/{pinId}/{articleId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteArticle(
            @PathVariable
            long articleId){
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
