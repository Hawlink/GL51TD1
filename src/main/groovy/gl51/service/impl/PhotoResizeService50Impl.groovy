package gl51.service.impl

import gl51.data.Photo
import gl51.service.PhotoService
import gl51.service.PhotoResizeService

import javax.inject.Inject

class PhotoResizeService50Impl implements PhotoResizeService {

    @Inject
    PhotoService service

    @Override
    Photo resizePhoto(int id) {
        Photo photo = service.getPhoto(id)
        ///
    }
}
