export default function renderSongs(songs, albumTitle) {
    return `
    <ul class="songs">
    ${songs.map(song => {
            return `
                        <li class="song">
                            <h5 class="song__title">${song.title}</h5>                       
                        </li>
                    `;
        })
        .join("")}
        </ul>
        <section class="add__song">
            <input type="hidden" class="add__song--album" placeholder="" value =${albumTitle}>
            <input type="text" class="add__song--title" placeholder="title">
            <input type="text" class="add__song--link" placeholder="link">
            <input type="text" class="add__song--duration" placeholder="duration">
            <button class="add__song--submit">Add Song</button>
        </section>
        `;
}