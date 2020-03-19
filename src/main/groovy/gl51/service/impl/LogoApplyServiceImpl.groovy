package gl51.service.impl

import gl51.data.Photo
import gl51.service.PhotoService
import gl51.service.LogoApplyService

import javax.inject.Inject

class LogoApplyServiceImpl implements LogoApplyService {

    @Inject
    PhotoService service

    @Override
    Photo applyLogo(int id) {
        Photo photo = service.getPhoto(id)
        ///
    }
}
