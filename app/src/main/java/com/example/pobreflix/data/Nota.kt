//package com.example.pobreflix.data
//
//viewModelScope.launch {
//    if (repository.getAllMovies().isEmpty()) {
//        repository.insertMovie(
//            MovieEntity(
//                1,
//                "Vingadores",
//                "2023",
//                "...",
//                "https://img.odcdn.com.br/wp-content/uploads/2023/06/Destaque-Vingadores.jpg"
//            )
//        )
//        repository.insertMovie(
//            MovieEntity(
//                2,
//                "Batman",
//                "2022",
//                "...",
//                "https://miro.medium.com/v2/resize:fit:1100/format:webp/1*XCkhUFwFgICyxL-aZ7qTwg.jpeg"
//            )
//        )
//        repository.insertMovie(
//            MovieEntity(
//                3,
//                "Homem-Aranha",
//                "2021",
//                "...",
//                "https://www.sonypictures.com.br/sites/brazil/files/2022-03/DP_3409108_TC_1400x2100_DP_3409112_SpiderManHomecoming_INTL_2017_2000x3000_BR_thumbnail_xlarge.jpg",
//
//                )
//        )
//        repository.insertMovie(
//            MovieEntity(
//                4,
//                "M.I.B - Homens de negro",
//                "2012",
//                "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzdddddddddddddddddddddddddddddddd.",
//                "https://mb.web.sapo.io/7fc899f9ebd0d921f36a43788b3603d5be49e324.jpg"
//            )
//        )
//        repository.insertMovie(
//            MovieEntity(
//                5,
//                "Naruto",
//                "2006",
//                "...",
//                "https://image.tmdb.org/t/p/w500/spiderman.jpg"
//            )
//        )
//        repository.insertMovie(
//            MovieEntity(
//                6,
//                "Zoro",
//                "2002",
//                "...",
//                "https://image.tmdb.org/t/p/w500/spiderman.jpg"
//            )
//        )
//
//        repository.insertMovie(
//            MovieEntity(
//                7,
//                "Sozinho em casa",
//                "2012",
//                "...",
//                "https://image.tmdb.org/t/p/w500/spiderman.jpg"
//            )
//        )
//        repository.insertMovie(
//            MovieEntity(
//                8,
//                "Jogos Mortais X",
//                "2021",
//                "...",
//                "https://image.tmdb.org/t/p/w500/spiderman.jpg"
//            )
//        )
//        repository.insertMovie(
//            MovieEntity(
//                9,
//                "A Freira",
//                "2020",
//                "...",
//                "https://image.tmdb.org/t/p/w500/spiderman.jpg"
//            )
//        )
//    }