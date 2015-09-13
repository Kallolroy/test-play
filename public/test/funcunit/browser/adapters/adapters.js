if (window.jasmine){
	steal('/assets/test/funcunit/browser/adapters/jasmine.js')
} else {
	steal('/assets/test/funcunit/browser/adapters/qunit.js')
}