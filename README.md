# PobreFlix
Primeiro projecto como Fullstack, Desenvolvimento Android, com Compose.

Relatório sobre o Aplicativo Pobreflix
Objetivo do Aplicativo
O Pobreflix é um aplicativo desenvolvido para permitir aos usuários descobrir e explorar uma vasta biblioteca de filmes e séries de maneira fácil e intuitiva. O aplicativo visa fornecer uma experiência de usuário agradável, utilizando um design limpo e moderno, além de funcionalidades que permitem que os usuários encontrem, pesquisem e visualizem detalhes sobre filmes de maneira eficiente.
A proposta do Pobreflix é criar uma plataforma acessível e de fácil navegação para os entusiastas do entretenimento, oferecendo uma interface simples que torna a busca por filmes e séries rápida e eficiente. Ao integrar informações de filmes e séries com base em uma API externa (como a TMDb API), o aplicativo oferece uma solução para quem busca opções de filmes e séries para assistir em qualquer momento, seja para lazer ou até mesmo para recomendações personalizadas.
Funcionalidades
1.	Tela Inicial (Home):
o	A tela inicial do aplicativo exibe filmes recomendados e populares em um formato de carrossel. O usuário pode ver resumos rápidos dos filmes e clicar para acessar mais detalhes.
o	A interface utiliza cards para exibir os filmes de forma organizada, permitindo a fácil navegação.
o	A tela também possui uma barra de navegação no topo para acesso rápido a diferentes seções do aplicativo.
2.	Pesquisa de Filmes:
o	Uma das principais funcionalidades do Pobreflix é a capacidade de pesquisa. O usuário pode digitar o nome de um filme na barra de pesquisa para filtrar filmes relevantes. À medida que o usuário digita, os filmes são filtrados em tempo real.
o	A lista de filmes correspondentes à pesquisa é exibida em cards, permitindo uma visualização clara do título, poster e data de lançamento de cada filme.
3.	Detalhes dos Filmes:
o	Ao clicar em um filme na lista ou carrossel, o usuário é redirecionado para uma tela de detalhes do filme.
o	A tela de detalhes contém informações completas sobre o filme, como sinopse, elenco, classificação, trailers, entre outras informações que ajudam o usuário a decidir se deseja assistir.
4.	Favoritos:
o	Os usuários têm a opção de adicionar filmes à sua lista de favoritos, permitindo que eles acompanhem os filmes de seu interesse.
o	Esta funcionalidade pode ser integrada com o banco de dados local (Room Database) para persistir os filmes favoritos mesmo quando o aplicativo é fechado.
5.	Notificações:
o	O aplicativo envia notificações para o usuário sobre novos filmes e séries adicionados à plataforma, lançamentos ou promoções especiais, mantendo o usuário sempre informado.
6.	Interface de Navegação Intuitiva:
o	A navegação dentro do aplicativo é feita por meio de botões e ícones intuitivos na parte inferior da tela, permitindo o fácil acesso às principais seções como Home, Pesquisa, Favoritos, e Configurações.
o	A interface é otimizada para dispositivos móveis, utilizando o padrão Material Design para garantir uma boa experiência de uso.
Tecnologias Utilizadas
•	Jetpack Compose: Utilizado para a construção da interface de usuário de forma declarativa e eficiente. Facilita a criação de telas e componentes visuais no Android.
•	Room Database: Para armazenar dados localmente, como filmes favoritos, garantindo uma experiência offline.
•	TMDb API: A API externa para obter dados atualizados sobre filmes e séries, incluindo detalhes como título, sinopse, data de lançamento, elenco, entre outros.
•	Coil: Para o carregamento e exibição de imagens, como os posters dos filmes, de forma eficiente e com suporte a placeholders enquanto as imagens estão sendo carregadas.
Estrutura do Banco de Dados
O aplicativo utiliza o Room Database para persistir dados dos filmes favoritos. A estrutura do banco de dados inclui tabelas para armazenar informações dos filmes, como:
•	MovieEntity: Contém os dados do filme, como título, data de lançamento, descrição, URL da imagem do poster, etc.
•	FilmesViewModel: Gerencia os dados e interage com o banco de dados para recuperar e armazenar filmes favoritos.
Desafios Encontrados
Durante o desenvolvimento, enfrentamos alguns desafios técnicos, como:
•	Integração com a API: Algumas dificuldades ocorreram ao lidar com a integração da API externa (TMDb), principalmente no que diz respeito ao tratamento de erros e à sincronização de dados de filmes.
•	Exibição de Imagens: Garantir a boa performance ao exibir imagens de filmes e séries foi um desafio, principalmente com o uso de imagens de grande tamanho. Utilizamos o Coil para melhorar a performance de carregamento de imagens.
Conclusão
O Pobreflix é um aplicativo com foco em usabilidade e simplicidade, destinado a quem busca uma maneira rápida e prática de encontrar filmes e séries para assistir. Através de funcionalidades como pesquisa, favoritos e detalhes completos dos filmes, o aplicativo proporciona uma experiência rica e imersiva. A integração com a TMDb API garante que o conteúdo esteja sempre atualizado, e a implementação do Room Database permite a persistência de dados importantes, como a lista de favoritos.
O objetivo do Pobreflix é atender às necessidades de usuários que buscam uma plataforma intuitiva para descobrir novos conteúdos de entretenimento, facilitando a busca e recomendação de filmes e séries para todos os gostos.

