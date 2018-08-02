package com.chadzhou.pinboardJob.converter;

import com.chadzhou.pinboardJob.entity.PinboardEntity;
import com.chadzhou.pinboardJob.model.Links;
import com.chadzhou.pinboardJob.model.Self;
import com.chadzhou.pinboardJob.model.response.PinboardResponse;
import com.chadzhou.pinboardJob.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;

public class PinboardEntityToPinboardResponseConverter implements Converter<PinboardEntity, PinboardResponse> {

    @Override
    public PinboardResponse convert(PinboardEntity source) {

        PinboardResponse pinboardResponse = new PinboardResponse();
        pinboardResponse.setPinboardId(source.getPinboardId());

        Links links = new Links();;
        Self self = new Self();
        self.setRef(ResourceConstants.PINBOARDS + "/" + source.getPinboardId());
        links.setSelf(self);

        pinboardResponse.setLinks(links);
        return pinboardResponse;
    }

}
