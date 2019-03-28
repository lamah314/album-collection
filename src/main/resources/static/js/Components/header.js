export default function renderHeader() {
    return `
        <figure class="figure-logo">
            <img class = "logo clickable" src="/html/img/logo.png" alt="logo">
        </figure>
        <h1>Down with the Hipsters!!!!</h1>
        <nav class="header-nav">
            <ul class="nav-list">
                <li class="nav-artist clickable">Artist</li>
                <li class="nav-album clickable">Album</li>
                <li class="nav-song clickable">Song</li>
            </ul>
        <nav>
        `;
}