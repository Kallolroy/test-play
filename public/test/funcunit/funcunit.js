//what we need from javascriptmvc or other places
steal('/assets/test/funcunit/syn/syn',
    '/assets/test/funcunit/browser/core.js',
    '/assets/test/funcunit/browser/adapters/adapters.js',
    '/assets/test/funcunit/browser/open.js',
    '/assets/test/funcunit/browser/actions.js',
    '/assets/test/funcunit/browser/getters.js',
    '/assets/test/funcunit/browser/traversers.js',
    '/assets/test/funcunit/browser/queue.js',
    '/assets/test/funcunit/browser/waits.js',
function(Syn, FuncUnit) {
    window.FuncUnit = window.S = FuncUnit;
    
    return FuncUnit;
});
